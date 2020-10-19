package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tieba.ala.alaar.sticker.a.h;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class b implements d {
    private static File fNW = h.getPrivateCaptureRootChildDir("duModel");
    private File dTV;
    private File fNX;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> fNY;
    private a fNZ;
    private com.baidu.tieba.ala.alaar.sticker.model.a fOa;
    private Sticker.AbilityModel fOb;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, fNW);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.fOa = aVar;
        this.mFolder = file;
        this.fNY = new LinkedList<>();
        this.dTV = new File(file, this.fOa.fNV);
        this.fNX = new File(file, this.fOa.fNV + ".zip");
        this.fOb = new Sticker.AbilityModel();
        this.fOb.setFile(this.dTV);
    }

    public String bIK() {
        if (this.fOa == null) {
            return null;
        }
        return this.fOa.fNV;
    }

    public Sticker.AbilityModel bIL() {
        return this.fOb;
    }

    public boolean isLoaded() {
        return this.dTV != null && this.dTV.exists();
    }

    public boolean isLoading() {
        return this.fNZ != null;
    }

    public File getLocalFile() {
        return this.dTV;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.d
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.dTV.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.fNY.push(aVar);
        }
        bIM();
    }

    private void bIM() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.fNZ = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bIv().a(this.fOa.mUrl, this.mFolder, this.fNX.getName(), this.fNZ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.fNZ = null;
        }
        if (this.fNY != null && !this.fNY.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.fNY != null && b.this.fNY.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fNY.pollFirst()).onCompleted(b.this.dTV.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.fNY != null && b.this.fNY.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fNY.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean Fu(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.dTV.getAbsolutePath() + ", sk:" + this.fOa.fNV);
            File file2 = new File(this.dTV + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            file2.renameTo(this.dTV);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.fNX.exists()) {
            this.fNX.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.fOa.mUrl);
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
                    b.this.Fu(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.fOa.mUrl);
            b.this.g(downloadException);
        }
    }
}
