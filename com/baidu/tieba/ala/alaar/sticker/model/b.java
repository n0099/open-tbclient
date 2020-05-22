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
    private static File eXl = h.getPrivateCaptureRootChildDir("duModel");
    private File cgl;
    private File eXm;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> eXn;
    private a eXo;
    private com.baidu.tieba.ala.alaar.sticker.model.a eXp;
    private Sticker.AbilityModel eXq;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, eXl);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.eXp = aVar;
        this.mFolder = file;
        this.eXn = new LinkedList<>();
        this.cgl = new File(file, this.eXp.eXk);
        this.eXm = new File(file, this.eXp.eXk + ".zip");
        this.eXq = new Sticker.AbilityModel();
        this.eXq.setFile(this.cgl);
    }

    public String bpQ() {
        if (this.eXp == null) {
            return null;
        }
        return this.eXp.eXk;
    }

    public Sticker.AbilityModel bpR() {
        return this.eXq;
    }

    public boolean isLoaded() {
        return this.cgl != null && this.cgl.exists();
    }

    public boolean isLoading() {
        return this.eXo != null;
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
            this.eXn.push(aVar);
        }
        bpS();
    }

    private void bpS() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.eXo = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bpC().a(this.eXp.mUrl, this.mFolder, this.eXm.getName(), this.eXo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.eXo = null;
        }
        if (this.eXn != null && !this.eXn.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.eXn != null && b.this.eXn.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.eXn.pollFirst()).onCompleted(b.this.cgl.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.eXn != null && b.this.eXn.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.eXn.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean AN(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.cgl.getAbsolutePath() + ", sk:" + this.eXp.eXk);
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
        if (this.eXm.exists()) {
            this.eXm.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.eXp.mUrl);
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.eXp.mUrl);
            b.this.g(downloadException);
        }
    }
}
