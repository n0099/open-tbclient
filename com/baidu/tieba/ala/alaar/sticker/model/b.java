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
    private static File fyx = h.getPrivateCaptureRootChildDir("duModel");
    private File dFM;
    private a fyA;
    private com.baidu.tieba.ala.alaar.sticker.model.a fyB;
    private Sticker.AbilityModel fyC;
    private File fyy;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> fyz;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, fyx);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.fyB = aVar;
        this.mFolder = file;
        this.fyz = new LinkedList<>();
        this.dFM = new File(file, this.fyB.fyw);
        this.fyy = new File(file, this.fyB.fyw + ".zip");
        this.fyC = new Sticker.AbilityModel();
        this.fyC.setFile(this.dFM);
    }

    public String bEH() {
        if (this.fyB == null) {
            return null;
        }
        return this.fyB.fyw;
    }

    public Sticker.AbilityModel bEI() {
        return this.fyC;
    }

    public boolean isLoaded() {
        return this.dFM != null && this.dFM.exists();
    }

    public boolean isLoading() {
        return this.fyA != null;
    }

    public File getLocalFile() {
        return this.dFM;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.d
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.dFM.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.fyz.push(aVar);
        }
        bEJ();
    }

    private void bEJ() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.fyA = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bEs().a(this.fyB.mUrl, this.mFolder, this.fyy.getName(), this.fyA);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.fyA = null;
        }
        if (this.fyz != null && !this.fyz.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.fyz != null && b.this.fyz.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fyz.pollFirst()).onCompleted(b.this.dFM.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.fyz != null && b.this.fyz.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fyz.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean El(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.dFM.getAbsolutePath() + ", sk:" + this.fyB.fyw);
            File file2 = new File(this.dFM + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.l(file, file2);
            file2.renameTo(this.dFM);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.fyy.exists()) {
            this.fyy.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.fyB.mUrl);
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
                    b.this.El(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.fyB.mUrl);
            b.this.g(downloadException);
        }
    }
}
