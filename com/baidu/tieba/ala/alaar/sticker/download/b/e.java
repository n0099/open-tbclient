package com.baidu.tieba.ala.alaar.sticker.download.b;

import com.baidu.tieba.ala.alaar.sticker.download.a.e;
import com.baidu.tieba.ala.alaar.sticker.download.a.f;
import com.baidu.tieba.ala.alaar.sticker.download.a.g;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes11.dex */
public class e implements e.a, com.baidu.tieba.ala.alaar.sticker.download.a.f, g.a {
    private com.baidu.tieba.ala.alaar.sticker.download.a gtb;
    private a gtj;
    private com.baidu.tieba.ala.alaar.sticker.download.c gtm;
    private com.baidu.tieba.ala.alaar.sticker.download.a.b gtn;
    private f.a gto;
    private com.baidu.tieba.ala.alaar.sticker.download.a.g gtp;
    private List<com.baidu.tieba.ala.alaar.sticker.download.a.e> mDownloadTasks;
    private Executor mExecutor;
    private int mStatus;
    private String mTag;

    public e(com.baidu.tieba.ala.alaar.sticker.download.c cVar, com.baidu.tieba.ala.alaar.sticker.download.a.b bVar, Executor executor, String str, com.baidu.tieba.ala.alaar.sticker.download.a aVar, f.a aVar2) {
        this.gtm = cVar;
        this.gtn = bVar;
        this.mExecutor = executor;
        this.mTag = str;
        this.gtb = aVar;
        this.gto = aVar2;
        init();
    }

    private void init() {
        this.gtj = new a(this.gtm.getName().toString(), this.gtm.getUri(), this.gtm.getFolder());
        this.mDownloadTasks = new LinkedList();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.f
    public boolean isRunning() {
        return this.mStatus == 101 || this.mStatus == 102 || this.mStatus == 103 || this.mStatus == 104;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.f
    public void start() {
        this.mStatus = 101;
        this.gtn.onStarted();
        startConnect();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.f
    public void pause() {
        if (this.gtp != null) {
            this.gtp.pause();
        }
        for (com.baidu.tieba.ala.alaar.sticker.download.a.e eVar : this.mDownloadTasks) {
            eVar.pause();
        }
        if (this.mStatus != 104) {
            onDownloadPaused();
        }
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.f
    public void cancel() {
        if (this.gtp != null) {
            this.gtp.cancel();
        }
        for (com.baidu.tieba.ala.alaar.sticker.download.a.e eVar : this.mDownloadTasks) {
            eVar.cancel();
        }
        if (this.mStatus != 104) {
            onDownloadCanceled();
        }
    }

    public void onDestroy() {
        this.gto.a(this.mTag, this);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g.a
    public void onConnecting() {
        this.mStatus = 102;
        this.gtn.onConnecting();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g.a
    public void onConnected(long j, long j2, boolean z) {
        if (this.gtp.isCanceled()) {
            onConnectCanceled();
            return;
        }
        this.mStatus = 103;
        this.gtn.onConnected(j, j2, z);
        this.gtj.setAcceptRanges(z);
        this.gtj.setLength(j2);
        download(j2, z);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g.a
    public void onConnectPaused() {
        onDownloadPaused();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g.a
    public void onConnectCanceled() {
        deleteFile();
        this.mStatus = 107;
        this.gtn.onConnectCanceled();
        onDestroy();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g.a
    public void b(DownloadException downloadException) {
        if (this.gtp.isCanceled()) {
            onConnectCanceled();
        } else if (this.gtp.isPaused()) {
            onDownloadPaused();
        } else {
            this.mStatus = 108;
            this.gtn.b(downloadException);
            onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e.a
    public void onDownloadProgress(long j, long j2) {
        this.gtn.onDownloadProgress(j, j2, (int) ((100 * j) / j2));
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e.a
    public void onDownloadCompleted(String str) {
        if (isAllComplete()) {
            this.mStatus = 105;
            this.gtn.onDownloadCompleted(str);
            onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e.a
    public void onDownloadPaused() {
        if (isAllPaused()) {
            this.mStatus = 106;
            this.gtn.onDownloadPaused();
            onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e.a
    public void onDownloadCanceled() {
        if (isAllCanceled()) {
            deleteFile();
            this.mStatus = 107;
            this.gtn.onDownloadCanceled();
            onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e.a
    public void c(DownloadException downloadException) {
        if (isAllFailed()) {
            this.mStatus = 108;
            this.gtn.c(downloadException);
            onDestroy();
        }
    }

    private void startConnect() {
        this.gtp = new f(this.gtm.getUri(), this);
        this.mExecutor.execute(this.gtp);
    }

    private void download(long j, boolean z) {
        this.mStatus = 104;
        initDownloadTasks(j, z);
        for (com.baidu.tieba.ala.alaar.sticker.download.a.e eVar : this.mDownloadTasks) {
            this.mExecutor.execute(eVar);
        }
    }

    private void initDownloadTasks(long j, boolean z) {
        int i;
        this.mDownloadTasks.clear();
        if (z) {
            List<i> multiThreadRecords = getMultiThreadRecords(j);
            int i2 = 0;
            Iterator<i> it = multiThreadRecords.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = (int) (it.next().getFinished() + i);
            }
            this.gtj.setFinished(i);
            for (i iVar : multiThreadRecords) {
                this.mDownloadTasks.add(new g(this.gtj, iVar, this));
            }
            return;
        }
        this.mDownloadTasks.add(new h(this.gtj, bPT(), this));
    }

    private List<i> getMultiThreadRecords(long j) {
        ArrayList arrayList = new ArrayList();
        int threadNum = this.gtb.getThreadNum();
        int i = 0;
        while (i < threadNum) {
            long j2 = j / threadNum;
            long j3 = i * j2;
            arrayList.add(new i(i, this.mTag, this.gtm.getUri(), j3, i == threadNum + (-1) ? j : (j2 + j3) - 1, 0L));
            i++;
        }
        return arrayList;
    }

    private i bPT() {
        return new i(0, this.mTag, this.gtm.getUri(), 0L);
    }

    private boolean isAllComplete() {
        for (com.baidu.tieba.ala.alaar.sticker.download.a.e eVar : this.mDownloadTasks) {
            if (!eVar.isComplete()) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllFailed() {
        for (com.baidu.tieba.ala.alaar.sticker.download.a.e eVar : this.mDownloadTasks) {
            if (eVar.isDownloading()) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllPaused() {
        for (com.baidu.tieba.ala.alaar.sticker.download.a.e eVar : this.mDownloadTasks) {
            if (eVar.isDownloading()) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllCanceled() {
        for (com.baidu.tieba.ala.alaar.sticker.download.a.e eVar : this.mDownloadTasks) {
            if (eVar.isDownloading()) {
                return false;
            }
        }
        return true;
    }

    private void deleteFile() {
        File file = new File(this.gtj.getDir(), this.gtj.getName());
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }
}
