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
    private static File gvq = i.getPrivateCaptureRootChildDir("duModel");
    private File cld;
    private File cle;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> gvr;
    private a gvs;
    private com.baidu.tieba.ala.alaar.sticker.model.a gvt;
    private Sticker.AbilityModel gvu;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, gvq);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.gvt = aVar;
        this.mFolder = file;
        this.gvr = new LinkedList<>();
        this.cld = new File(file, this.gvt.gvp);
        this.cle = new File(file, this.gvt.gvp + ".zip");
        this.gvu = new Sticker.AbilityModel();
        this.gvu.setFile(this.cld);
    }

    public String bTn() {
        if (this.gvt == null) {
            return null;
        }
        return this.gvt.gvp;
    }

    public Sticker.AbilityModel bTo() {
        return this.gvu;
    }

    public boolean isLoaded() {
        return this.cld != null && this.cld.exists();
    }

    public boolean isLoading() {
        return this.gvs != null;
    }

    public File getLocalFile() {
        return this.cld;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.e
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.cld.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.gvr.push(aVar);
        }
        aev();
    }

    private void aev() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gvs = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bSW().a(this.gvt.mUrl, this.mFolder, this.cle.getName(), this.gvs);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gvs = null;
        }
        if (this.gvr != null && !this.gvr.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.gvr != null && b.this.gvr.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gvr.pollFirst()).onCompleted(b.this.cld.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.gvr != null && b.this.gvr.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gvr.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean jM(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.cld.getAbsolutePath() + ", sk:" + this.gvt.gvp);
            File file2 = new File(this.cld + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            file2.renameTo(this.cld);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.cle.exists()) {
            this.cle.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.gvt.mUrl);
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
                    b.this.jM(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.gvt.mUrl);
            b.this.g(downloadException);
        }
    }
}
