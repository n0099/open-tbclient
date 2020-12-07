package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends g implements j {
    private d gCe;
    private String gCf;
    private float dLG = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.gCf = str;
        bTq();
    }

    private void bTq() {
        this.gCe = c.GP(this.gCf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTr() {
        if (bTH() != null) {
            bTH().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTs() {
        if (bTH() != null) {
            bTH().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gCe == null) {
            return false;
        }
        return this.gCe.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bTH() != null) {
            bTH().a(this, getProgress());
        }
        bTt();
    }

    public void bTt() {
        if (this.gCe == null) {
            bTr();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gCe.isLoaded()) {
                this.gCe.bTA();
                bTu();
                return;
            }
            bTs();
        }
    }

    private void bTu() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gCe.mUrl);
        downloadData.setPath(this.gCe.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bTr();
                    return;
                }
                b.this.dLG = downloadData2.getProcess();
                if (b.this.bTH() != null) {
                    b.this.bTH().a(b.this, b.this.getProgress());
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
                    if (!b.this.gCe.onResLoaded(downloadData2.getPath())) {
                        b.this.bTr();
                    } else {
                        b.this.bTs();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bTr();
            }
        });
        com.baidu.tbadk.download.d.bCj().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bTv() {
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
        return this.dLG;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        return isReady();
    }
}
