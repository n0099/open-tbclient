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
    private static File fXh = i.getPrivateCaptureRootChildDir("duModel");
    private File ecr;
    private File fXi;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> fXj;
    private a fXk;
    private com.baidu.tieba.ala.alaar.sticker.model.a fXl;
    private Sticker.AbilityModel fXm;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, fXh);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.fXl = aVar;
        this.mFolder = file;
        this.fXj = new LinkedList<>();
        this.ecr = new File(file, this.fXl.fXg);
        this.fXi = new File(file, this.fXl.fXg + ".zip");
        this.fXm = new Sticker.AbilityModel();
        this.fXm.setFile(this.ecr);
    }

    public String bLk() {
        if (this.fXl == null) {
            return null;
        }
        return this.fXl.fXg;
    }

    public Sticker.AbilityModel bLl() {
        return this.fXm;
    }

    public boolean isLoaded() {
        return this.ecr != null && this.ecr.exists();
    }

    public boolean isLoading() {
        return this.fXk != null;
    }

    public File getLocalFile() {
        return this.ecr;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.e
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.ecr.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.fXj.push(aVar);
        }
        bLm();
    }

    private void bLm() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.fXk = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bKT().a(this.fXl.mUrl, this.mFolder, this.fXi.getName(), this.fXk);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.fXk = null;
        }
        if (this.fXj != null && !this.fXj.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.fXj != null && b.this.fXj.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fXj.pollFirst()).onCompleted(b.this.ecr.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.fXj != null && b.this.fXj.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fXj.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean FT(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.ecr.getAbsolutePath() + ", sk:" + this.fXl.fXg);
            File file2 = new File(this.ecr + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            file2.renameTo(this.ecr);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.fXi.exists()) {
            this.fXi.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.fXl.mUrl);
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
                    b.this.FT(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.fXl.mUrl);
            b.this.g(downloadException);
        }
    }
}
