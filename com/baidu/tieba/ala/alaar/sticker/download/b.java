package com.baidu.tieba.ala.alaar.sticker.download;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.baidu.tieba.ala.alaar.sticker.download.a.f;
import com.baidu.tieba.ala.alaar.sticker.download.b.e;
import com.baidu.tieba.ala.alaar.sticker.download.c;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class b implements f.a {
    private static volatile b eKj;
    private a eKk;
    private com.baidu.tieba.ala.alaar.sticker.download.a.d eKl;
    private ExecutorService mExecutorService;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Map<String, f> mDownloaderMap = new LinkedHashMap();

    public static b bki() {
        if (eKj == null) {
            synchronized (b.class) {
                if (eKj == null) {
                    eKj = new b();
                }
            }
        }
        return eKj;
    }

    private b() {
        a(new a());
    }

    private void a(@NonNull a aVar) {
        if (aVar.getThreadNum() > aVar.getMaxThreadNum()) {
            throw new IllegalArgumentException("thread num must < max thread num");
        }
        this.eKk = aVar;
        this.mExecutorService = Executors.newFixedThreadPool(this.eKk.getMaxThreadNum());
        this.eKl = new com.baidu.tieba.ala.alaar.sticker.download.b.c(this.mHandler);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.f.a
    public void a(final String str, f fVar) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.download.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mDownloaderMap.containsKey(str)) {
                    b.this.mDownloaderMap.remove(str);
                }
            }
        });
    }

    public void a(c cVar, String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        String createKey = createKey(str);
        if (!isDownloadRequestRunning(createKey)) {
            e eVar = new e(cVar, new com.baidu.tieba.ala.alaar.sticker.download.b.b(this.eKl, aVar), this.mExecutorService, createKey, this.eKk, this);
            this.mDownloaderMap.put(createKey, eVar);
            eVar.start();
        }
    }

    public void a(String str, String str2, String str3, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        a(new c.a().yY(str).L(new File(str2)).k(str3).bkj(), str, aVar);
    }

    public void a(String str, File file, String str2, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        a(new c.a().yY(str).L(file).k(str2).bkj(), str, aVar);
    }

    public void pause(String str) {
        String createKey = createKey(str);
        if (this.mDownloaderMap.containsKey(createKey)) {
            f fVar = this.mDownloaderMap.get(createKey);
            if (fVar != null && fVar.isRunning()) {
                fVar.pause();
            }
            this.mDownloaderMap.remove(createKey);
        }
    }

    public void cancel(String str) {
        String createKey = createKey(str);
        if (this.mDownloaderMap.containsKey(createKey)) {
            f fVar = this.mDownloaderMap.get(createKey);
            if (fVar != null) {
                fVar.cancel();
            }
            this.mDownloaderMap.remove(createKey);
        }
    }

    public void pauseAll() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.download.b.2
            @Override // java.lang.Runnable
            public void run() {
                for (f fVar : b.this.mDownloaderMap.values()) {
                    if (fVar != null && fVar.isRunning()) {
                        fVar.pause();
                    }
                }
            }
        });
    }

    public void cancelAll() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.download.b.3
            @Override // java.lang.Runnable
            public void run() {
                for (f fVar : b.this.mDownloaderMap.values()) {
                    if (fVar != null && fVar.isRunning()) {
                        fVar.cancel();
                    }
                }
            }
        });
    }

    public boolean isRunning(String str) {
        f fVar;
        String createKey = createKey(str);
        if (!this.mDownloaderMap.containsKey(createKey) || (fVar = this.mDownloaderMap.get(createKey)) == null) {
            return false;
        }
        return fVar.isRunning();
    }

    private boolean isDownloadRequestRunning(String str) {
        f fVar;
        if (this.mDownloaderMap.containsKey(str) && (fVar = this.mDownloaderMap.get(str)) != null && fVar.isRunning()) {
            com.baidu.tieba.ala.alaar.sticker.b.a.i("DownloadManager", "DownloadInfo has been started!");
            return true;
        }
        return false;
    }

    private String createKey(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Tag can't be null!");
        }
        return String.valueOf(str.hashCode());
    }
}
