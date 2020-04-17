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
    private static File eKJ = h.getPrivateCaptureRootChildDir("duModel");
    private File bVK;
    private File eKK;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> eKL;
    private a eKM;
    private com.baidu.tieba.ala.alaar.sticker.model.a eKN;
    private Sticker.AbilityModel eKO;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, eKJ);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.eKN = aVar;
        this.mFolder = file;
        this.eKL = new LinkedList<>();
        this.bVK = new File(file, this.eKN.eKI);
        this.eKK = new File(file, this.eKN.eKI + ".zip");
        this.eKO = new Sticker.AbilityModel();
        this.eKO.setFile(this.bVK);
    }

    public String bky() {
        if (this.eKN == null) {
            return null;
        }
        return this.eKN.eKI;
    }

    public Sticker.AbilityModel bkz() {
        return this.eKO;
    }

    public boolean isLoaded() {
        return this.bVK != null && this.bVK.exists();
    }

    public boolean isLoading() {
        return this.eKM != null;
    }

    public File getLocalFile() {
        return this.bVK;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.d
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.bVK.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.eKL.push(aVar);
        }
        bkA();
    }

    private void bkA() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.eKM = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bkk().a(this.eKN.mUrl, this.mFolder, this.eKK.getName(), this.eKM);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.eKM = null;
        }
        if (this.eKL != null && !this.eKL.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.eKL != null && b.this.eKL.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.eKL.pollFirst()).onCompleted(b.this.bVK.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.eKL != null && b.this.eKL.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.eKL.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean ze(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.bVK.getAbsolutePath() + ", sk:" + this.eKN.eKI);
            File file2 = new File(this.bVK + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.k(file, file2);
            file2.renameTo(this.bVK);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.eKK.exists()) {
            this.eKK.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.eKN.mUrl);
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
                    b.this.ze(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.eKN.mUrl);
            b.this.g(downloadException);
        }
    }
}
