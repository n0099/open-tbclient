package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes10.dex */
public class b extends g implements j {
    private d gMg;
    private String gMh;
    private float dRU = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.gMh = str;
        bSP();
    }

    private void bSP() {
        this.gMg = c.Gb(this.gMh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSQ() {
        if (bTg() != null) {
            bTg().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSR() {
        if (bTg() != null) {
            bTg().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gMg == null) {
            return false;
        }
        return this.gMg.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bTg() != null) {
            bTg().a(this, getProgress());
        }
        bSS();
    }

    public void bSS() {
        if (this.gMg == null) {
            bSQ();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gMg.isLoaded()) {
                this.gMg.bSZ();
                bST();
                return;
            }
            bSR();
        }
    }

    private void bST() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gMg.mUrl);
        downloadData.setPath(this.gMg.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bSQ();
                    return;
                }
                b.this.dRU = downloadData2.getProcess();
                if (b.this.bTg() != null) {
                    b.this.bTg().a(b.this, b.this.getProgress());
                }
            }

            @Override // com.baidu.tbadk.download.c
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.c
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                if (downloadData2 != null && !StringUtils.isNull(downloadData2.getPath())) {
                    if (!b.this.gMg.onResLoaded(downloadData2.getPath())) {
                        b.this.bSQ();
                    } else {
                        b.this.bSR();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bSQ();
            }
        });
        com.baidu.tbadk.download.d.bBd().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bSU() {
        return this;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        return this.dRU;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean isCompleted() {
        return isReady();
    }
}
