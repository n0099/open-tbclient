package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends g implements j {
    private d gdX;
    private String gdY;
    private float drY = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.gdY = str;
        bLj();
    }

    private void bLj() {
        this.gdX = c.FN(this.gdY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLk() {
        if (bLC() != null) {
            bLC().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLl() {
        if (bLC() != null) {
            bLC().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gdX == null) {
            return false;
        }
        return this.gdX.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bLC() != null) {
            bLC().a(this, getProgress());
        }
        bLm();
    }

    public void bLm() {
        if (this.gdX == null) {
            bLk();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gdX.isLoaded()) {
                this.gdX.bLt();
                bLn();
                return;
            }
            bLl();
        }
    }

    private void bLn() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gdX.mUrl);
        downloadData.setPath(this.gdX.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bLk();
                    return;
                }
                b.this.drY = downloadData2.getProcess();
                if (b.this.bLC() != null) {
                    b.this.bLC().a(b.this, b.this.getProgress());
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
                    if (!b.this.gdX.onResLoaded(downloadData2.getPath())) {
                        b.this.bLk();
                    } else {
                        b.this.bLl();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bLk();
            }
        });
        com.baidu.tbadk.download.d.bvb().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bLo() {
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
        return this.drY;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        return isReady();
    }
}
