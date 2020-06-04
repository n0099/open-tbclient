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
    private static File eXw = h.getPrivateCaptureRootChildDir("duModel");
    private File cgl;
    private com.baidu.tieba.ala.alaar.sticker.model.a eXA;
    private Sticker.AbilityModel eXB;
    private File eXx;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> eXy;
    private a eXz;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, eXw);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.eXA = aVar;
        this.mFolder = file;
        this.eXy = new LinkedList<>();
        this.cgl = new File(file, this.eXA.eXv);
        this.eXx = new File(file, this.eXA.eXv + ".zip");
        this.eXB = new Sticker.AbilityModel();
        this.eXB.setFile(this.cgl);
    }

    public String bpS() {
        if (this.eXA == null) {
            return null;
        }
        return this.eXA.eXv;
    }

    public Sticker.AbilityModel bpT() {
        return this.eXB;
    }

    public boolean isLoaded() {
        return this.cgl != null && this.cgl.exists();
    }

    public boolean isLoading() {
        return this.eXz != null;
    }

    public File getLocalFile() {
        return this.cgl;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.d
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.cgl.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.eXy.push(aVar);
        }
        bpU();
    }

    private void bpU() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.eXz = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bpE().a(this.eXA.mUrl, this.mFolder, this.eXx.getName(), this.eXz);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.eXz = null;
        }
        if (this.eXy != null && !this.eXy.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.eXy != null && b.this.eXy.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.eXy.pollFirst()).onCompleted(b.this.cgl.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.eXy != null && b.this.eXy.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.eXy.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean AN(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.cgl.getAbsolutePath() + ", sk:" + this.eXA.eXv);
            File file2 = new File(this.cgl + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.k(file, file2);
            file2.renameTo(this.cgl);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.eXx.exists()) {
            this.eXx.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.eXA.mUrl);
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
                    b.this.AN(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.eXA.mUrl);
            b.this.g(downloadException);
        }
    }
}
