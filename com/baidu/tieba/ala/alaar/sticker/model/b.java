package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tieba.ala.alaar.sticker.a.i;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class b implements e {
    private static File gqJ = i.getPrivateCaptureRootChildDir("duModel");
    private File cgq;
    private File cgr;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> gqK;
    private a gqL;
    private com.baidu.tieba.ala.alaar.sticker.model.a gqM;
    private Sticker.AbilityModel gqN;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, gqJ);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.gqM = aVar;
        this.mFolder = file;
        this.gqK = new LinkedList<>();
        this.cgq = new File(file, this.gqM.gqI);
        this.cgr = new File(file, this.gqM.gqI + ".zip");
        this.gqN = new Sticker.AbilityModel();
        this.gqN.setFile(this.cgq);
    }

    public String bPw() {
        if (this.gqM == null) {
            return null;
        }
        return this.gqM.gqI;
    }

    public Sticker.AbilityModel bPx() {
        return this.gqN;
    }

    public boolean isLoaded() {
        return this.cgq != null && this.cgq.exists();
    }

    public boolean isLoading() {
        return this.gqL != null;
    }

    public File getLocalFile() {
        return this.cgq;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.e
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.cgq.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.gqK.push(aVar);
        }
        aaD();
    }

    private void aaD() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gqL = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bPf().a(this.gqM.mUrl, this.mFolder, this.cgr.getName(), this.gqL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gqL = null;
        }
        if (this.gqK != null && !this.gqK.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.gqK != null && b.this.gqK.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gqK.pollFirst()).onCompleted(b.this.cgq.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.gqK != null && b.this.gqK.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gqK.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean iB(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.cgq.getAbsolutePath() + ", sk:" + this.gqM.gqI);
            File file2 = new File(this.cgq + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            file2.renameTo(this.cgq);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.cgr.exists()) {
            this.cgr.delete();
        }
        f(downloadException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends com.baidu.tieba.ala.alaar.sticker.download.a.a {
        a() {
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onStarted() {
            super.onStarted();
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.gqM.mUrl);
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
                    b.this.iB(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.gqM.mUrl);
            b.this.g(downloadException);
        }
    }
}
