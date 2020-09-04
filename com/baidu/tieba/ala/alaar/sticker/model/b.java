package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tieba.ala.alaar.sticker.a.h;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class b implements d {
    private static File fyB = h.getPrivateCaptureRootChildDir("duModel");
    private File dFQ;
    private File fyC;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> fyD;
    private a fyE;
    private com.baidu.tieba.ala.alaar.sticker.model.a fyF;
    private Sticker.AbilityModel fyG;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, fyB);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.fyF = aVar;
        this.mFolder = file;
        this.fyD = new LinkedList<>();
        this.dFQ = new File(file, this.fyF.fyA);
        this.fyC = new File(file, this.fyF.fyA + ".zip");
        this.fyG = new Sticker.AbilityModel();
        this.fyG.setFile(this.dFQ);
    }

    public String bEI() {
        if (this.fyF == null) {
            return null;
        }
        return this.fyF.fyA;
    }

    public Sticker.AbilityModel bEJ() {
        return this.fyG;
    }

    public boolean isLoaded() {
        return this.dFQ != null && this.dFQ.exists();
    }

    public boolean isLoading() {
        return this.fyE != null;
    }

    public File getLocalFile() {
        return this.dFQ;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.d
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.dFQ.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.fyD.push(aVar);
        }
        bEK();
    }

    private void bEK() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.fyE = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bEt().a(this.fyF.mUrl, this.mFolder, this.fyC.getName(), this.fyE);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.fyE = null;
        }
        if (this.fyD != null && !this.fyD.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.fyD != null && b.this.fyD.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fyD.pollFirst()).onCompleted(b.this.dFQ.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.fyD != null && b.this.fyD.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fyD.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean Em(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.dFQ.getAbsolutePath() + ", sk:" + this.fyF.fyA);
            File file2 = new File(this.dFQ + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.l(file, file2);
            file2.renameTo(this.dFQ);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.fyC.exists()) {
            this.fyC.delete();
        }
        f(downloadException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a extends com.baidu.tieba.ala.alaar.sticker.download.a.a {
        a() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onStarted() {
            super.onStarted();
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.fyF.mUrl);
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
                    b.this.Em(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.fyF.mUrl);
            b.this.g(downloadException);
        }
    }
}
