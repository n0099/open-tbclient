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
    private static File eKO = h.getPrivateCaptureRootChildDir("duModel");
    private File bVQ;
    private File eKP;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> eKQ;
    private a eKR;
    private com.baidu.tieba.ala.alaar.sticker.model.a eKS;
    private Sticker.AbilityModel eKT;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, eKO);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.eKS = aVar;
        this.mFolder = file;
        this.eKQ = new LinkedList<>();
        this.bVQ = new File(file, this.eKS.eKN);
        this.eKP = new File(file, this.eKS.eKN + ".zip");
        this.eKT = new Sticker.AbilityModel();
        this.eKT.setFile(this.bVQ);
    }

    public String bkw() {
        if (this.eKS == null) {
            return null;
        }
        return this.eKS.eKN;
    }

    public Sticker.AbilityModel bkx() {
        return this.eKT;
    }

    public boolean isLoaded() {
        return this.bVQ != null && this.bVQ.exists();
    }

    public boolean isLoading() {
        return this.eKR != null;
    }

    public File getLocalFile() {
        return this.bVQ;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.d
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.bVQ.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.eKQ.push(aVar);
        }
        bky();
    }

    private void bky() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.eKR = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bki().a(this.eKS.mUrl, this.mFolder, this.eKP.getName(), this.eKR);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.eKR = null;
        }
        if (this.eKQ != null && !this.eKQ.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.eKQ != null && b.this.eKQ.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.eKQ.pollFirst()).onCompleted(b.this.bVQ.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.eKQ != null && b.this.eKQ.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.eKQ.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean zh(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.bVQ.getAbsolutePath() + ", sk:" + this.eKS.eKN);
            File file2 = new File(this.bVQ + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.k(file, file2);
            file2.renameTo(this.bVQ);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.eKP.exists()) {
            this.eKP.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.eKS.mUrl);
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
                    b.this.zh(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.eKS.mUrl);
            b.this.g(downloadException);
        }
    }
}
