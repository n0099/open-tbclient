package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tieba.ala.alaar.sticker.a.h;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class b implements d {
    private static File fhT = h.getPrivateCaptureRootChildDir("duModel");
    private File ckZ;
    private File fhU;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> fhV;
    private a fhW;
    private com.baidu.tieba.ala.alaar.sticker.model.a fhX;
    private Sticker.AbilityModel fhY;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, fhT);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.fhX = aVar;
        this.mFolder = file;
        this.fhV = new LinkedList<>();
        this.ckZ = new File(file, this.fhX.fhS);
        this.fhU = new File(file, this.fhX.fhS + ".zip");
        this.fhY = new Sticker.AbilityModel();
        this.fhY.setFile(this.ckZ);
    }

    public String bsC() {
        if (this.fhX == null) {
            return null;
        }
        return this.fhX.fhS;
    }

    public Sticker.AbilityModel bsD() {
        return this.fhY;
    }

    public boolean isLoaded() {
        return this.ckZ != null && this.ckZ.exists();
    }

    public boolean isLoading() {
        return this.fhW != null;
    }

    public File getLocalFile() {
        return this.ckZ;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.d
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.ckZ.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.fhV.push(aVar);
        }
        bsE();
    }

    private void bsE() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.fhW = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bsn().a(this.fhX.mUrl, this.mFolder, this.fhU.getName(), this.fhW);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.fhW = null;
        }
        if (this.fhV != null && !this.fhV.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.fhV != null && b.this.fhV.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fhV.pollFirst()).onCompleted(b.this.ckZ.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.fhV != null && b.this.fhV.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fhV.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean Bg(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.ckZ.getAbsolutePath() + ", sk:" + this.fhX.fhS);
            File file2 = new File(this.ckZ + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.k(file, file2);
            file2.renameTo(this.ckZ);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.fhU.exists()) {
            this.fhU.delete();
        }
        f(downloadException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends com.baidu.tieba.ala.alaar.sticker.download.a.a {
        a() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onStarted() {
            super.onStarted();
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.fhX.mUrl);
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onProgress(long j, long j2, int i) {
            super.onProgress(j, j2, i);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.alaar.sticker.model.b$a$1] */
        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(final String str) {
            super.onCompleted(str);
            new Thread() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    b.this.Bg(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.fhX.mUrl);
            b.this.g(downloadException);
        }
    }
}
