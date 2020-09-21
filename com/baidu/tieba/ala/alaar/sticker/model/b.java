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
    private static File fBN = h.getPrivateCaptureRootChildDir("duModel");
    private File dHU;
    private File fBO;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> fBP;
    private a fBQ;
    private com.baidu.tieba.ala.alaar.sticker.model.a fBR;
    private Sticker.AbilityModel fBS;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, fBN);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.fBR = aVar;
        this.mFolder = file;
        this.fBP = new LinkedList<>();
        this.dHU = new File(file, this.fBR.fBM);
        this.fBO = new File(file, this.fBR.fBM + ".zip");
        this.fBS = new Sticker.AbilityModel();
        this.fBS.setFile(this.dHU);
    }

    public String bFY() {
        if (this.fBR == null) {
            return null;
        }
        return this.fBR.fBM;
    }

    public Sticker.AbilityModel bFZ() {
        return this.fBS;
    }

    public boolean isLoaded() {
        return this.dHU != null && this.dHU.exists();
    }

    public boolean isLoading() {
        return this.fBQ != null;
    }

    public File getLocalFile() {
        return this.dHU;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.d
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.dHU.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.fBP.push(aVar);
        }
        bGa();
    }

    private void bGa() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.fBQ = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bFJ().a(this.fBR.mUrl, this.mFolder, this.fBO.getName(), this.fBQ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.fBQ = null;
        }
        if (this.fBP != null && !this.fBP.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.fBP != null && b.this.fBP.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fBP.pollFirst()).onCompleted(b.this.dHU.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.fBP != null && b.this.fBP.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fBP.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean EJ(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.dHU.getAbsolutePath() + ", sk:" + this.fBR.fBM);
            File file2 = new File(this.dHU + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.l(file, file2);
            file2.renameTo(this.dHU);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.fBO.exists()) {
            this.fBO.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.fBR.mUrl);
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
                    b.this.EJ(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.fBR.mUrl);
            b.this.g(downloadException);
        }
    }
}
