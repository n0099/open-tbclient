package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends g implements j {
    private d fRF;
    private String fRG;
    private float dfR = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.fRG = str;
        bIz();
    }

    private void bIz() {
        this.fRF = c.Fc(this.fRG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIA() {
        if (bIS() != null) {
            bIS().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIB() {
        if (bIS() != null) {
            bIS().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.fRF == null) {
            return false;
        }
        return this.fRF.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bIS() != null) {
            bIS().a(this, getProgress());
        }
        bIC();
    }

    public void bIC() {
        if (this.fRF == null) {
            bIA();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.fRF.isLoaded()) {
                this.fRF.bIJ();
                bID();
                return;
            }
            bIB();
        }
    }

    private void bID() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.fRF.mUrl);
        downloadData.setPath(this.fRF.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bIA();
                    return;
                }
                b.this.dfR = downloadData2.getProcess();
                if (b.this.bIS() != null) {
                    b.this.bIS().a(b.this, b.this.getProgress());
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
                    if (!b.this.fRF.onResLoaded(downloadData2.getPath())) {
                        b.this.bIA();
                    } else {
                        b.this.bIB();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bIA();
            }
        });
        com.baidu.tbadk.download.d.bsr().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bIE() {
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
        return this.dfR;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ij() {
        return isReady();
    }
}
