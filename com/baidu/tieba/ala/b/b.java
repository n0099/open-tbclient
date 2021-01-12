package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes9.dex */
public class b extends g implements j {
    private d gJm;
    private String gJn;
    private float dPO = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.gJn = str;
        bSf();
    }

    private void bSf() {
        this.gJm = c.FC(this.gJn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSg() {
        if (bSw() != null) {
            bSw().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSh() {
        if (bSw() != null) {
            bSw().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gJm == null) {
            return false;
        }
        return this.gJm.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bSw() != null) {
            bSw().a(this, getProgress());
        }
        bSi();
    }

    public void bSi() {
        if (this.gJm == null) {
            bSg();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gJm.isLoaded()) {
                this.gJm.bSp();
                bSj();
                return;
            }
            bSh();
        }
    }

    private void bSj() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gJm.mUrl);
        downloadData.setPath(this.gJm.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bSg();
                    return;
                }
                b.this.dPO = downloadData2.getProcess();
                if (b.this.bSw() != null) {
                    b.this.bSw().a(b.this, b.this.getProgress());
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
                    if (!b.this.gJm.onResLoaded(downloadData2.getPath())) {
                        b.this.bSg();
                    } else {
                        b.this.bSh();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bSg();
            }
        });
        com.baidu.tbadk.download.d.bAL().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bSk() {
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
        return this.dPO;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean isCompleted() {
        return isReady();
    }
}
