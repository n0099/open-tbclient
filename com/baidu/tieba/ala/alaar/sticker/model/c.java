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
    private static File gvq = i.getPrivateCaptureRootChildDir("duMakeup");
    private File cld;
    private File cle;
    private List<com.baidu.tieba.ala.alaar.sticker.download.a.a> cly;
    private a gvy;
    private com.baidu.tieba.ala.alaar.makeup.c gvz;
    private File mFolder;

    public c(com.baidu.tieba.ala.alaar.makeup.c cVar) {
        this(cVar, gvq);
    }

    public c(com.baidu.tieba.ala.alaar.makeup.c cVar, File file) {
        this.gvz = cVar;
        this.mFolder = file;
        this.cly = new ArrayList();
        if (!TextUtils.isEmpty(this.gvz.bSq())) {
            this.cld = new File(file, this.gvz.bSr());
            this.cle = new File(file, this.gvz.bSr() + ".zip");
            this.gvz.Gh(this.cld.getAbsolutePath());
        }
    }

    public boolean isLoaded() {
        return this.cld == null || this.cld.exists();
    }

    public boolean isLoading() {
        return this.gvy != null;
    }

    public File getLocalFile() {
        return this.cld;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.e
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.cld.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null && !this.cly.contains(aVar)) {
            this.cly.add(aVar);
        }
        aev();
    }

    private void aev() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gvy = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bSW().a(this.gvz.bSq(), this.mFolder, this.cle.getName(), this.gvy);
                }
            }
        }
    }

    protected void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gvy = null;
        }
        if (this.cly != null && !this.cly.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.c.1
                @Override // java.lang.Runnable
                public void run() {
                    int i = 0;
                    if (!isLoaded) {
                        while (true) {
                            int i2 = i;
                            if (i2 >= c.this.cly.size()) {
                                break;
                            }
                            com.baidu.tieba.ala.alaar.sticker.download.a.a aVar = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.cly.get(i2);
                            if (aVar != null) {
                                aVar.a(downloadException);
                            }
                            i = i2 + 1;
                        }
                    } else {
                        while (true) {
                            int i3 = i;
                            if (i3 >= c.this.cly.size()) {
                                break;
                            }
                            com.baidu.tieba.ala.alaar.sticker.download.a.a aVar2 = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.cly.get(i3);
                            if (aVar2 != null) {
                                aVar2.onCompleted(c.this.cld.getAbsolutePath());
                            }
                            i = i3 + 1;
                        }
                    }
                    c.this.cly.clear();
                }
            });
        }
    }

    protected boolean jM(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onCompleted-unzip:" + str + "\nto " + this.cld.getAbsolutePath() + ", sk:" + this.gvz.bSr());
            File file2 = new File(this.cld + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            file2.renameTo(this.cld);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.cle.exists()) {
            this.cle.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onStarted url:" + c.this.gvz.bSq());
            if (c.this.cly != null && !c.this.cly.isEmpty()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < c.this.cly.size()) {
                                com.baidu.tieba.ala.alaar.sticker.download.a.a aVar = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.cly.get(i2);
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
                    c.this.jM(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + c.this.gvz.bSq());
            c.this.g(downloadException);
        }
    }
}
