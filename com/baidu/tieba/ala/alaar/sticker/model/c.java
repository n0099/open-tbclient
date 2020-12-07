package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.tieba.ala.alaar.sticker.a.i;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements e {
    private static File gkQ = i.getPrivateCaptureRootChildDir("duMakeup");
    private List<com.baidu.tieba.ala.alaar.sticker.download.a.a> ceI;
    private File cet;
    private File ceu;
    private a gkY;
    private com.baidu.tieba.ala.alaar.makeup.c gkZ;
    private File mFolder;

    public c(com.baidu.tieba.ala.alaar.makeup.c cVar) {
        this(cVar, gkQ);
    }

    public c(com.baidu.tieba.ala.alaar.makeup.c cVar, File file) {
        this.gkZ = cVar;
        this.mFolder = file;
        this.ceI = new ArrayList();
        if (!TextUtils.isEmpty(this.gkZ.bPP())) {
            this.cet = new File(file, this.gkZ.bPQ());
            this.ceu = new File(file, this.gkZ.bPQ() + ".zip");
            this.gkZ.Gi(this.cet.getAbsolutePath());
        }
    }

    public boolean isLoaded() {
        return this.cet == null || this.cet.exists();
    }

    public boolean isLoading() {
        return this.gkY != null;
    }

    public File getLocalFile() {
        return this.cet;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.e
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.cet.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null && !this.ceI.contains(aVar)) {
            this.ceI.add(aVar);
        }
        bQP();
    }

    private void bQP() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gkY = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bQw().a(this.gkZ.bPP(), this.mFolder, this.ceu.getName(), this.gkY);
                }
            }
        }
    }

    protected void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gkY = null;
        }
        if (this.ceI != null && !this.ceI.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.c.1
                @Override // java.lang.Runnable
                public void run() {
                    int i = 0;
                    if (!isLoaded) {
                        while (true) {
                            int i2 = i;
                            if (i2 >= c.this.ceI.size()) {
                                break;
                            }
                            com.baidu.tieba.ala.alaar.sticker.download.a.a aVar = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.ceI.get(i2);
                            if (aVar != null) {
                                aVar.a(downloadException);
                            }
                            i = i2 + 1;
                        }
                    } else {
                        while (true) {
                            int i3 = i;
                            if (i3 >= c.this.ceI.size()) {
                                break;
                            }
                            com.baidu.tieba.ala.alaar.sticker.download.a.a aVar2 = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.ceI.get(i3);
                            if (aVar2 != null) {
                                aVar2.onCompleted(c.this.cet.getAbsolutePath());
                            }
                            i = i3 + 1;
                        }
                    }
                    c.this.ceI.clear();
                }
            });
        }
    }

    protected boolean Gx(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onCompleted-unzip:" + str + "\nto " + this.cet.getAbsolutePath() + ", sk:" + this.gkZ.bPQ());
            File file2 = new File(this.cet + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            file2.renameTo(this.cet);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.ceu.exists()) {
            this.ceu.delete();
        }
        f(downloadException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends com.baidu.tieba.ala.alaar.sticker.download.a.a {
        a() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onStarted() {
            super.onStarted();
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onStarted url:" + c.this.gkZ.bPP());
            if (c.this.ceI != null && !c.this.ceI.isEmpty()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < c.this.ceI.size()) {
                                com.baidu.tieba.ala.alaar.sticker.download.a.a aVar = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.ceI.get(i2);
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
                    c.this.Gx(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + c.this.gkZ.bPP());
            c.this.g(downloadException);
        }
    }
}
