package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tieba.ala.alaar.sticker.a.h;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class b implements d {
    private static File fnc = h.getPrivateCaptureRootChildDir("duModel");
    private File dwf;
    private File fnd;
    private LinkedList<com.baidu.tieba.ala.alaar.sticker.download.a.a> fne;
    private a fnf;
    private com.baidu.tieba.ala.alaar.sticker.model.a fng;
    private Sticker.AbilityModel fnh;
    private File mFolder;

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar) {
        this(aVar, fnc);
    }

    public b(com.baidu.tieba.ala.alaar.sticker.model.a aVar, File file) {
        this.fng = aVar;
        this.mFolder = file;
        this.fne = new LinkedList<>();
        this.dwf = new File(file, this.fng.fnb);
        this.fnd = new File(file, this.fng.fnb + ".zip");
        this.fnh = new Sticker.AbilityModel();
        this.fnh.setFile(this.dwf);
    }

    public String bvM() {
        if (this.fng == null) {
            return null;
        }
        return this.fng.fnb;
    }

    public Sticker.AbilityModel bvN() {
        return this.fnh;
    }

    public boolean isLoaded() {
        return this.dwf != null && this.dwf.exists();
    }

    public boolean isLoading() {
        return this.fnf != null;
    }

    public File getLocalFile() {
        return this.dwf;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.d
    public void b(com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        if (isLoaded()) {
            if (aVar != null) {
                aVar.onCompleted(this.dwf.getAbsolutePath());
                return;
            }
            return;
        }
        if (aVar != null) {
            this.fne.push(aVar);
        }
        bvO();
    }

    private void bvO() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.fnf = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bvx().a(this.fng.mUrl, this.mFolder, this.fnd.getName(), this.fnf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(final DownloadException downloadException) {
        synchronized (this) {
            this.fnf = null;
        }
        if (this.fne != null && !this.fne.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (isLoaded) {
                        while (b.this.fne != null && b.this.fne.size() > 0) {
                            ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fne.pollFirst()).onCompleted(b.this.dwf.getAbsolutePath());
                        }
                        return;
                    }
                    while (b.this.fne != null && b.this.fne.size() > 0) {
                        ((com.baidu.tieba.ala.alaar.sticker.download.a.a) b.this.fne.pollFirst()).a(downloadException);
                    }
                }
            });
        }
    }

    protected boolean BR(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + this.dwf.getAbsolutePath() + ", sk:" + this.fng.fnb);
            File file2 = new File(this.dwf + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.l(file, file2);
            file2.renameTo(this.dwf);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }

    protected void g(DownloadException downloadException) {
        if (this.fnd.exists()) {
            this.fnd.delete();
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onStarted url:" + b.this.fng.mUrl);
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
                    b.this.BR(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + b.this.fng.mUrl);
            b.this.g(downloadException);
        }
    }
}
