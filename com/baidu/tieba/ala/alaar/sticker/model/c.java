package com.baidu.tieba.ala.alaar.sticker.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.tieba.ala.alaar.sticker.a.i;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements e {
    private static File gcY = i.getPrivateCaptureRootChildDir("duMakeup");
    private File eij;
    private File gcZ;
    private List<com.baidu.tieba.ala.alaar.sticker.download.a.a> gdh;
    private a gdi;
    private com.baidu.tieba.ala.alaar.makeup.c gdj;
    private File mFolder;

    public c(com.baidu.tieba.ala.alaar.makeup.c cVar) {
        this(cVar, gcY);
    }

    public c(com.baidu.tieba.ala.alaar.makeup.c cVar, File file) {
        this.gdj = cVar;
        this.mFolder = file;
        this.gdh = new ArrayList();
        if (!TextUtils.isEmpty(this.gdj.bML())) {
            this.eij = new File(file, this.gdj.bMM());
            this.gcZ = new File(file, this.gdj.bMM() + ".zip");
            this.gdj.FS(this.eij.getAbsolutePath());
        }
    }

    public boolean isLoaded() {
        return this.eij == null || this.eij.exists();
    }

    public boolean isLoading() {
        return this.gdi != null;
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
        if (aVar != null && !this.gdh.contains(aVar)) {
            this.gdh.add(aVar);
        }
        bNL();
    }

    private void bNL() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    this.gdi = new a();
                    com.baidu.tieba.ala.alaar.sticker.download.b.bNs().a(this.gdj.bML(), this.mFolder, this.gcZ.getName(), this.gdi);
                }
            }
        }
    }

    protected void f(final DownloadException downloadException) {
        synchronized (this) {
            this.gdi = null;
        }
        if (this.gdh != null && !this.gdh.isEmpty()) {
            final boolean isLoaded = isLoaded();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.c.1
                @Override // java.lang.Runnable
                public void run() {
                    int i = 0;
                    if (!isLoaded) {
                        while (true) {
                            int i2 = i;
                            if (i2 >= c.this.gdh.size()) {
                                break;
                            }
                            com.baidu.tieba.ala.alaar.sticker.download.a.a aVar = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.gdh.get(i2);
                            if (aVar != null) {
                                aVar.a(downloadException);
                            }
                            i = i2 + 1;
                        }
                    } else {
                        while (true) {
                            int i3 = i;
                            if (i3 >= c.this.gdh.size()) {
                                break;
                            }
                            com.baidu.tieba.ala.alaar.sticker.download.a.a aVar2 = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.gdh.get(i3);
                            if (aVar2 != null) {
                                aVar2.onCompleted(c.this.eij.getAbsolutePath());
                            }
                            i = i3 + 1;
                        }
                    }
                    c.this.gdh.clear();
                }
            });
        }
    }

    protected boolean Gh(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onCompleted-unzip:" + str + "\nto " + this.eij.getAbsolutePath() + ", sk:" + this.gdj.bMM());
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
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onStarted url:" + c.this.gdj.bML());
            if (c.this.gdh != null && !c.this.gdh.isEmpty()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.model.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < c.this.gdh.size()) {
                                com.baidu.tieba.ala.alaar.sticker.download.a.a aVar = (com.baidu.tieba.ala.alaar.sticker.download.a.a) c.this.gdh.get(i2);
                                if (aVar != null) {
                                    aVar.onStarted();
                                }
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onProgress(long j, long j2, int i) {
            super.onProgress(j, j2, i);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.alaar.sticker.model.c$a$2] */
        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(final String str) {
            super.onCompleted(str);
            new Thread() { // from class: com.baidu.tieba.ala.alaar.sticker.model.c.a.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    c.this.Gh(str);
                }
            }.start();
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            super.a(downloadException);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuMakeupModel", "onFailed " + (downloadException != null ? downloadException.getErrorMessage() : "") + "\n" + c.this.gdj.bML());
            c.this.g(downloadException);
        }
    }
}
