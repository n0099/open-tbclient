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
    private static File gtt = i.getPrivateCaptureRootChildDir("duModel");
    private File ckA;
    private File ckB;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> gtu;
    private a gtv;
    private com.baidu.tieba.ala.alaar.sticker.model.a gtw;
    private Sticker.AbilityModel gtx;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, gtt);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.gtw = aVar;
        this.mFolder = file;
        this.gtu = new LinkedList<>();
        this.ckA = new File(file, this.gtw.gts);
        this.ckB = new File(file, this.gtw.gts + ".zip");
        this.gtx = new Sticker.AbilityModel();
        this.gtx.setFile(this.ckA);
    }

    public String bQa() {
        if (this.gtw == null) {
            return null;
        }
        return this.gtw.gts;
    }

    public Sticker.AbilityModel bQb() {
        return this.gtx;
    }

    public boolean isLoaded() {
        return this.ckA != null && this.ckA.exists();
    }

    public boolean isLoading() {
        return this.gtv != null;
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
            this.gtu.push(aVar);
        }
        acr();
    }

    private void acr() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gtv = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bPJ().a(this.gtw.mUrl, this.mFolder, this.ckB.getName(), this.gtv);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gtv = null;
        }
        if (this.gtu != null && !this.gtu.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.gtu != null && b.this.gtu.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gtu.pollFirst()).onCompleted(b.this.ckA.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.gtu != null && b.this.gtu.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gtu.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean jh(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.ckA.getAbsolutePath() + ", sk:" + this.gtw.gts);
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.gtw.mUrl);
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.gtw.mUrl);
            b.this.g(downloadException);
        }
    }
}
