package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.tieba.ala.alaar.sticker.a.i;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements e {
    private static File gtH = i.getPrivateCaptureRootChildDir("duMakeup");
    private File ckA;
    private File ckB;
    private List<com.baidu.tieba.ala.alaar.sticker.download.a.a> ckV;
    private a gtP;
    private com.baidu.tieba.ala.alaar.makeup.c gtQ;
    private File mFolder;

    public c(com.baidu.tieba.ala.alaar.makeup.c cVar) {
        this(cVar, gtH);
    }

    public c(com.baidu.tieba.ala.alaar.makeup.c cVar, File file) {
        this.gtQ = cVar;
        this.mFolder = file;
        this.ckV = new ArrayList();
        if (!TextUtils.isEmpty(this.gtQ.bPk())) {
            this.ckA = new File(file, this.gtQ.bPl());
            this.ckB = new File(file, this.gtQ.bPl() + ".zip");
            this.gtQ.Fu(this.ckA.getAbsolutePath());
        }
    }

    public boolean isLoaded() {
        return this.ckA == null || this.ckA.exists();
    }

    public boolean isLoading() {
        return this.gtP != null;
    }

    public File getLocalFile() {
        return this.ckA;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.e
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.ckA.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null && !this.ckV.contains(aVar)) {
            this.ckV.add(aVar);
        }
        acr();
    }

    private void acr() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gtP = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bPQ().a(this.gtQ.bPk(), this.mFolder, this.ckB.getName(), this.gtP);
                }
            }
        }
    }

    protected void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gtP = null;
        }
        if (this.ckV != null && !this.ckV.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.c.1
                @Override // java.lang.Runnable
                public void run() {
                    int i = 0;
                    if (!isLoaded) {
                        while (true) {
                            int i2 = i;
                            if (i2 >= c.this.ckV.size()) {
                                break;
                            }
                            com.baidu.tieba.ala.alaar.sticker.download.a.a aVar = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.ckV.get(i2);
                            if (aVar != null) {
                                aVar.a(downloadException);
                            }
                            i = i2 + 1;
                        }
                    } else {
                        while (true) {
                            int i3 = i;
                            if (i3 >= c.this.ckV.size()) {
                                break;
                            }
                            com.baidu.tieba.ala.alaar.sticker.download.a.a aVar2 = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.ckV.get(i3);
                            if (aVar2 != null) {
                                aVar2.onCompleted(c.this.ckA.getAbsolutePath());
                            }
                            i = i3 + 1;
                        }
                    }
                    c.this.ckV.clear();
                }
            });
        }
    }

    protected boolean jh(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onCompleted-unzip:" + str + "\nto " + this.ckA.getAbsolutePath() + ", sk:" + this.gtQ.bPl());
            File file2 = new File(this.ckA + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.c(file, file2);
            file2.renameTo(this.ckA);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.ckB.exists()) {
            this.ckB.delete();
        }
        f(downloadException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.tieba.ala.alaar.sticker.download.a.a {
        a() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onStarted() {
            super.onStarted();
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onStarted url:" + c.this.gtQ.bPk());
            if (c.this.ckV != null && !c.this.ckV.isEmpty()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < c.this.ckV.size()) {
                                com.baidu.tieba.ala.alaar.sticker.download.a.a aVar = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.ckV.get(i2);
                                if (aVar != null) {
                                    aVar.onStarted();
                                }
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onProgress(long j, long j2, int i) {
            super.onProgress(j, j2, i);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.alaar.sticker.model.c$a$2] */
        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(final String str) {
            super.onCompleted(str);
            new Thread() { // from class: com.baidu.tieba.ala.alaar.sticker.model.c.a.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    c.this.jh(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + c.this.gtQ.bPk());
            c.this.g(downloadException);
        }
    }
}
