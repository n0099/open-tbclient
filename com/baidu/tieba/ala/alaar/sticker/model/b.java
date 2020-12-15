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
    private static File gkS = i.getPrivateCaptureRootChildDir("duModel");
    private File cet;
    private File ceu;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> gkT;
    private a gkU;
    private com.baidu.tieba.ala.alaar.sticker.model.a gkV;
    private Sticker.AbilityModel gkW;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, gkS);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.gkV = aVar;
        this.mFolder = file;
        this.gkT = new LinkedList<>();
        this.cet = new File(file, this.gkV.gkR);
        this.ceu = new File(file, this.gkV.gkR + ".zip");
        this.gkW = new Sticker.AbilityModel();
        this.gkW.setFile(this.cet);
    }

    public String bQO() {
        if (this.gkV == null) {
            return null;
        }
        return this.gkV.gkR;
    }

    public Sticker.AbilityModel bQP() {
        return this.gkW;
    }

    public boolean isLoaded() {
        return this.cet != null && this.cet.exists();
    }

    public boolean isLoading() {
        return this.gkU != null;
    }

    public File getLocalFile() {
        return this.cet;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.e
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.cet.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.gkT.push(aVar);
        }
        bQQ();
    }

    private void bQQ() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gkU = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bQx().a(this.gkV.mUrl, this.mFolder, this.ceu.getName(), this.gkU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gkU = null;
        }
        if (this.gkT != null && !this.gkT.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.gkT != null && b.this.gkT.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gkT.pollFirst()).onCompleted(b.this.cet.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.gkT != null && b.this.gkT.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gkT.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean Gx(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.cet.getAbsolutePath() + ", sk:" + this.gkV.gkR);
            File file2 = new File(this.cet + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            file2.renameTo(this.cet);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.ceu.exists()) {
            this.ceu.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.gkV.mUrl);
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
                    b.this.Gx(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.gkV.mUrl);
            b.this.g(downloadException);
        }
    }
}
