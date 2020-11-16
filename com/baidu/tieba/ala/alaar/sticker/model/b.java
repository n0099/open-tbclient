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
    private static File gcF = i.getPrivateCaptureRootChildDir("duModel");
    private File egC;
    private File gcG;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> gcH;
    private a gcI;
    private com.baidu.tieba.ala.alaar.sticker.model.a gcJ;
    private Sticker.AbilityModel gcK;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, gcF);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.gcJ = aVar;
        this.mFolder = file;
        this.gcH = new LinkedList<>();
        this.egC = new File(file, this.gcJ.gcE);
        this.gcG = new File(file, this.gcJ.gcE + ".zip");
        this.gcK = new Sticker.AbilityModel();
        this.gcK.setFile(this.egC);
    }

    public String bNc() {
        if (this.gcJ == null) {
            return null;
        }
        return this.gcJ.gcE;
    }

    public Sticker.AbilityModel bNd() {
        return this.gcK;
    }

    public boolean isLoaded() {
        return this.egC != null && this.egC.exists();
    }

    public boolean isLoading() {
        return this.gcI != null;
    }

    public File getLocalFile() {
        return this.egC;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.e
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.egC.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.gcH.push(aVar);
        }
        bNe();
    }

    private void bNe() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gcI = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bML().a(this.gcJ.mUrl, this.mFolder, this.gcG.getName(), this.gcI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gcI = null;
        }
        if (this.gcH != null && !this.gcH.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.gcH != null && b.this.gcH.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gcH.pollFirst()).onCompleted(b.this.egC.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.gcH != null && b.this.gcH.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gcH.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean FI(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.egC.getAbsolutePath() + ", sk:" + this.gcJ.gcE);
            File file2 = new File(this.egC + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            file2.renameTo(this.egC);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.gcG.exists()) {
            this.gcG.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.gcJ.mUrl);
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
                    b.this.FI(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.gcJ.mUrl);
            b.this.g(downloadException);
        }
    }
}
