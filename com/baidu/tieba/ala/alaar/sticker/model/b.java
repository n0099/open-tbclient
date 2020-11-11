package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tieba.ala.alaar.sticker.a.i;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class b implements e {
    private static File gcY = i.getPrivateCaptureRootChildDir("duModel");
    private File eij;
    private File gcZ;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> gda;
    private a gdb;
    private com.baidu.tieba.ala.alaar.sticker.model.a gdc;
    private Sticker.AbilityModel gdd;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, gcY);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.gdc = aVar;
        this.mFolder = file;
        this.gda = new LinkedList<>();
        this.eij = new File(file, this.gdc.gcX);
        this.gcZ = new File(file, this.gdc.gcX + ".zip");
        this.gdd = new Sticker.AbilityModel();
        this.gdd.setFile(this.eij);
    }

    public String bNJ() {
        if (this.gdc == null) {
            return null;
        }
        return this.gdc.gcX;
    }

    public Sticker.AbilityModel bNK() {
        return this.gdd;
    }

    public boolean isLoaded() {
        return this.eij != null && this.eij.exists();
    }

    public boolean isLoading() {
        return this.gdb != null;
    }

    public File getLocalFile() {
        return this.eij;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.e
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.eij.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.gda.push(aVar);
        }
        bNL();
    }

    private void bNL() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gdb = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bNs().a(this.gdc.mUrl, this.mFolder, this.gcZ.getName(), this.gdb);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gdb = null;
        }
        if (this.gda != null && !this.gda.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.gda != null && b.this.gda.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gda.pollFirst()).onCompleted(b.this.eij.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.gda != null && b.this.gda.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gda.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean Gh(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.eij.getAbsolutePath() + ", sk:" + this.gdc.gcX);
            File file2 = new File(this.eij + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            file2.renameTo(this.eij);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.gcZ.exists()) {
            this.gcZ.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.gdc.mUrl);
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
                    b.this.Gh(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.gdc.mUrl);
            b.this.g(downloadException);
        }
    }
}
