package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes10.dex */
public class b extends g implements j {
    private d gLS;
    private String gLT;
    private float dRU = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.gLT = str;
        bSI();
    }

    private void bSI() {
        this.gLS = c.Ga(this.gLT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSJ() {
        if (bSZ() != null) {
            bSZ().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSK() {
        if (bSZ() != null) {
            bSZ().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gLS == null) {
            return false;
        }
        return this.gLS.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bSZ() != null) {
            bSZ().a(this, getProgress());
        }
        bSL();
    }

    public void bSL() {
        if (this.gLS == null) {
            bSJ();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gLS.isLoaded()) {
                this.gLS.bSS();
                bSM();
                return;
            }
            bSK();
        }
    }

    private void bSM() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gLS.mUrl);
        downloadData.setPath(this.gLS.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bSJ();
                    return;
                }
                b.this.dRU = downloadData2.getProcess();
                if (b.this.bSZ() != null) {
                    b.this.bSZ().a(b.this, b.this.getProgress());
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
                    if (!b.this.gLS.onResLoaded(downloadData2.getPath())) {
                        b.this.bSJ();
                    } else {
                        b.this.bSK();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bSJ();
            }
        });
        com.baidu.tbadk.download.d.bBd().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bSN() {
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
