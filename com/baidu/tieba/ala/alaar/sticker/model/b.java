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
    private static File gkQ = i.getPrivateCaptureRootChildDir("duModel");
    private File cet;
    private File ceu;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> gkR;
    private a gkS;
    private com.baidu.tieba.ala.alaar.sticker.model.a gkT;
    private Sticker.AbilityModel gkU;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, gkQ);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.gkT = aVar;
        this.mFolder = file;
        this.gkR = new LinkedList<>();
        this.cet = new File(file, this.gkT.gkP);
        this.ceu = new File(file, this.gkT.gkP + ".zip");
        this.gkU = new Sticker.AbilityModel();
        this.gkU.setFile(this.cet);
    }

    public String bQN() {
        if (this.gkT == null) {
            return null;
        }
        return this.gkT.gkP;
    }

    public Sticker.AbilityModel bQO() {
        return this.gkU;
    }

    public boolean isLoaded() {
        return this.cet != null && this.cet.exists();
    }

    public boolean isLoading() {
        return this.gkS != null;
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
            this.gkR.push(aVar);
        }
        bQP();
    }

    private void bQP() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gkS = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bQw().a(this.gkT.mUrl, this.mFolder, this.ceu.getName(), this.gkS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gkS = null;
        }
        if (this.gkR != null && !this.gkR.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.gkR != null && b.this.gkR.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gkR.pollFirst()).onCompleted(b.this.cet.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.gkR != null && b.this.gkR.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.gkR.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean Gx(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.cet.getAbsolutePath() + ", sk:" + this.gkT.gkP);
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.gkT.mUrl);
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.gkT.mUrl);
            b.this.g(downloadException);
        }
    }
}
