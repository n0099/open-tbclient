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
/* loaded from: classes7.dex */
public class e implements e.a, com.baidu.tieba.ala.alaar.sticker.download.a.f, g.a {
    private com.baidu.tieba.ala.alaar.sticker.download.a fxV;
    private a fyd;
    private com.baidu.tieba.ala.alaar.sticker.download.c fyg;
    private com.baidu.tieba.ala.alaar.sticker.download.a.b fyh;
    private f.a fyi;
    private com.baidu.tieba.ala.alaar.sticker.download.a.g fyj;
    private List<com.baidu.tieba.ala.alaar.sticker.download.a.e> mDownloadTasks;
    private Executor mExecutor;
    private int mStatus;
    private String mTag;

    public e(com.baidu.tieba.ala.alaar.sticker.download.c cVar, com.baidu.tieba.ala.alaar.sticker.download.a.b bVar, Executor executor, String str, com.baidu.tieba.ala.alaar.sticker.download.a aVar, f.a aVar2) {
        this.fyg = cVar;
        this.fyh = bVar;
        this.mExecutor = executor;
        this.mTag = str;
        this.fxV = aVar;
        this.fyi = aVar2;
        init();
    }

    private void init() {
        this.fyd = new a(this.fyg.getName().toString(), this.fyg.getUri(), this.fyg.getFolder());
        this.mDownloadTasks = new LinkedList();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.f
    public boolean isRunning() {
        return this.mStatus == 101 || this.mStatus == 102 || this.mStatus == 103 || this.mStatus == 104;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.f
    public void start() {
        this.mStatus = 101;
        this.fyh.onStarted();
        startConnect();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.f
    public void pause() {
        if (this.fyj != null) {
            this.fyj.pause();
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
        if (this.fyj != null) {
            this.fyj.cancel();
        }
        for (com.baidu.tieba.ala.alaar.sticker.download.a.e eVar : this.mDownloadTasks) {
            eVar.cancel();
        }
        if (this.mStatus != 104) {
            onDownloadCanceled();
        }
    }

    public void onDestroy() {
        this.fyi.a(this.mTag, this);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g.a
    public void onConnecting() {
        this.mStatus = 102;
        this.fyh.onConnecting();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g.a
    public void onConnected(long j, long j2, boolean z) {
        if (this.fyj.isCanceled()) {
            onConnectCanceled();
            return;
        }
        this.mStatus = 103;
        this.fyh.onConnected(j, j2, z);
        this.fyd.setAcceptRanges(z);
        this.fyd.setLength(j2);
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
        this.fyh.onConnectCanceled();
        onDestroy();
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g.a
    public void b(DownloadException downloadException) {
        if (this.fyj.isCanceled()) {
            onConnectCanceled();
        } else if (this.fyj.isPaused()) {
            onDownloadPaused();
        } else {
            this.mStatus = 108;
            this.fyh.b(downloadException);
            onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e.a
    public void onDownloadProgress(long j, long j2) {
        this.fyh.onDownloadProgress(j, j2, (int) ((100 * j) / j2));
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e.a
    public void onDownloadCompleted(String str) {
        if (isAllComplete()) {
            this.mStatus = 105;
            this.fyh.onDownloadCompleted(str);
            onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e.a
    public void onDownloadPaused() {
        if (isAllPaused()) {
            this.mStatus = 106;
            this.fyh.onDownloadPaused();
            onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e.a
    public void onDownloadCanceled() {
        if (isAllCanceled()) {
            deleteFile();
            this.mStatus = 107;
            this.fyh.onDownloadCanceled();
            onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e.a
    public void c(DownloadException downloadException) {
        if (isAllFailed()) {
            this.mStatus = 108;
            this.fyh.c(downloadException);
            onDestroy();
        }
    }

    private void startConnect() {
        this.fyj = new f(this.fyg.getUri(), this);
        this.mExecutor.execute(this.fyj);
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
            this.fyd.setFinished(i);
            for (i iVar : multiThreadRecords) {
                this.mDownloadTasks.add(new g(this.fyd, iVar, this));
            }
            return;
        }
        this.mDownloadTasks.add(new h(this.fyd, bEw(), this));
    }

    private List<i> getMultiThreadRecords(long j) {
        ArrayList arrayList = new ArrayList();
        int threadNum = this.fxV.getThreadNum();
        int i = 0;
        while (i < threadNum) {
            long j2 = j / threadNum;
            long j3 = i * j2;
            arrayList.add(new i(i, this.mTag, this.fyg.getUri(), j3, i == threadNum + (-1) ? j : (j2 + j3) - 1, 0L));
            i++;
        }
        return arrayList;
    }

    private i bEw() {
        return new i(0, this.mTag, this.fyg.getUri(), 0L);
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
        File file = new File(this.fyd.getDir(), this.fyd.getName());
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }
}
