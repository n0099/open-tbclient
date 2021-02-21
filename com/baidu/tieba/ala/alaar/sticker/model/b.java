package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tieba.ala.alaar.sticker.a.i;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public class b implements e {
    private static File gtH = i.getPrivateCaptureRootChildDir("duModel");
    private File ckA;
    private File ckB;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> gtI;
    private a gtJ;
    private com.baidu.tieba.ala.alaar.sticker.model.a gtK;
    private Sticker.AbilityModel gtL;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, gtH);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.gtK = aVar;
        this.mFolder = file;
        this.gtI = new LinkedList<>();
        this.ckA = new File(file, this.gtK.gtG);
        this.ckB = new File(file, this.gtK.gtG + ".zip");
        this.gtL = new Sticker.AbilityModel();
        this.gtL.setFile(this.ckA);
    }

    public String bQh() {
        if (this.gtK == null) {
            return null;
        }
        return this.gtK.gtG;
    }

    public Sticker.AbilityModel bQi() {
        return this.gtL;
    }

    public boolean isLoaded() {
        return this.ckA != null && this.ckA.exists();
    }

    public boolean isLoading() {
        return this.gtJ != null;
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
        if (aVar != null) {
            this.gtI.push(aVar);
        }
        acr();
    }

    private void acr() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gtJ = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bPQ().a(this.gtK.mUrl, this.mFolder, this.ckB.getName(), this.gtJ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gtJ = null;
        }
        if (this.gtI != null && !this.gtI.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.gtI != null && b.this.gtI.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gtI.pollFirst()).onCompleted(b.this.ckA.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.gtI != null && b.this.gtI.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gtI.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean jh(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.ckA.getAbsolutePath() + ", sk:" + this.gtK.gtG);
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.gtK.mUrl);
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
                    b.this.jh(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.gtK.mUrl);
            b.this.g(downloadException);
        }
    }
}
