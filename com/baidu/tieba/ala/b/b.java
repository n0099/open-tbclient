package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes9.dex */
public class b extends g implements j {
    private d gNP;
    private String gNQ;
    private float dTv = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.gNQ = str;
        bSV();
    }

    private void bSV() {
        this.gNP = c.Gk(this.gNQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSW() {
        if (bTm() != null) {
            bTm().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSX() {
        if (bTm() != null) {
            bTm().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gNP == null) {
            return false;
        }
        return this.gNP.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bTm() != null) {
            bTm().a(this, getProgress());
        }
        bSY();
    }

    public void bSY() {
        if (this.gNP == null) {
            bSW();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gNP.isLoaded()) {
                this.gNP.bTf();
                bSZ();
                return;
            }
            bSX();
        }
    }

    private void bSZ() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gNP.mUrl);
        downloadData.setPath(this.gNP.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bSW();
                    return;
                }
                b.this.dTv = downloadData2.getProcess();
                if (b.this.bTm() != null) {
                    b.this.bTm().a(b.this, b.this.getProgress());
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
                    if (!b.this.gNP.onResLoaded(downloadData2.getPath())) {
                        b.this.bSW();
                    } else {
                        b.this.bSX();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bSW();
            }
        });
        com.baidu.tbadk.download.d.bBg().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bTa() {
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
        return this.dTv;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean isCompleted() {
        return isReady();
    }
}
