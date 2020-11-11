package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends g implements j {
    private d gtO;
    private String gtP;
    private float dGp = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.gtP = str;
        bQl();
    }

    private void bQl() {
        this.gtO = c.GA(this.gtP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQm() {
        if (bQE() != null) {
            bQE().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQn() {
        if (bQE() != null) {
            bQE().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gtO == null) {
            return false;
        }
        return this.gtO.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bQE() != null) {
            bQE().a(this, getProgress());
        }
        bQo();
    }

    public void bQo() {
        if (this.gtO == null) {
            bQm();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gtO.isLoaded()) {
                this.gtO.bQv();
                bQp();
                return;
            }
            bQn();
        }
    }

    private void bQp() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gtO.mUrl);
        downloadData.setPath(this.gtO.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bQm();
                    return;
                }
                b.this.dGp = downloadData2.getProcess();
                if (b.this.bQE() != null) {
                    b.this.bQE().a(b.this, b.this.getProgress());
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
                    if (!b.this.gtO.onResLoaded(downloadData2.getPath())) {
                        b.this.bQm();
                    } else {
                        b.this.bQn();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bQm();
            }
        });
        com.baidu.tbadk.download.d.bzt().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bQq() {
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
        return this.dGp;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        return isReady();
    }
}
