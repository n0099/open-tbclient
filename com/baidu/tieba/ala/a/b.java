package com.baidu.tieba.ala.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends g implements j {
    private d fOq;
    private String fOr;
    private float ddM = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.fOr = str;
        bHq();
    }

    private void bHq() {
        this.fOq = c.EE(this.fOr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHr() {
        if (bHJ() != null) {
            bHJ().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHs() {
        if (bHJ() != null) {
            bHJ().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.j
    public boolean isReady() {
        if (this.fOq == null) {
            return false;
        }
        return this.fOq.isLoaded();
    }

    @Override // com.baidu.tieba.ala.a.j
    public void load() {
        if (bHJ() != null) {
            bHJ().a(this, getProgress());
        }
        bHt();
    }

    public void bHt() {
        if (this.fOq == null) {
            bHr();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.fOq.isLoaded()) {
                this.fOq.bHA();
                bHu();
                return;
            }
            bHs();
        }
    }

    private void bHu() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.fOq.mUrl);
        downloadData.setPath(this.fOq.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.a.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bHr();
                    return;
                }
                b.this.ddM = downloadData2.getProcess();
                if (b.this.bHJ() != null) {
                    b.this.bHJ().a(b.this, b.this.getProgress());
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
                    if (!b.this.fOq.onResLoaded(downloadData2.getPath())) {
                        b.this.bHr();
                    } else {
                        b.this.bHs();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bHr();
            }
        });
        com.baidu.tbadk.download.d.brr().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.a.j
    public g bHv() {
        return this;
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onAttach() {
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onDetach() {
    }

    @Override // com.baidu.tieba.ala.a.g
    public float getProgress() {
        return this.ddM;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean ij() {
        return isReady();
    }
}
