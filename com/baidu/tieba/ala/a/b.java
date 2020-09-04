package com.baidu.tieba.ala.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends g implements j {
    private d fOu;
    private String fOv;
    private float ddQ = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.fOv = str;
        bHr();
    }

    private void bHr() {
        this.fOu = c.EF(this.fOv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHs() {
        if (bHK() != null) {
            bHK().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHt() {
        if (bHK() != null) {
            bHK().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.j
    public boolean isReady() {
        if (this.fOu == null) {
            return false;
        }
        return this.fOu.isLoaded();
    }

    @Override // com.baidu.tieba.ala.a.j
    public void load() {
        if (bHK() != null) {
            bHK().a(this, getProgress());
        }
        bHu();
    }

    public void bHu() {
        if (this.fOu == null) {
            bHs();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.fOu.isLoaded()) {
                this.fOu.bHB();
                bHv();
                return;
            }
            bHt();
        }
    }

    private void bHv() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.fOu.mUrl);
        downloadData.setPath(this.fOu.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.a.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bHs();
                    return;
                }
                b.this.ddQ = downloadData2.getProcess();
                if (b.this.bHK() != null) {
                    b.this.bHK().a(b.this, b.this.getProgress());
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
                    if (!b.this.fOu.onResLoaded(downloadData2.getPath())) {
                        b.this.bHs();
                    } else {
                        b.this.bHt();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bHs();
            }
        });
        com.baidu.tbadk.download.d.brs().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.a.j
    public g bHw() {
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
        return this.ddQ;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean ij() {
        return isReady();
    }
}
