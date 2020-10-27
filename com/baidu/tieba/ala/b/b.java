package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends g implements j {
    private d gob;
    private String goc;
    private float dAx = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.goc = str;
        bNL();
    }

    private void bNL() {
        this.gob = c.Gm(this.goc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNM() {
        if (bOe() != null) {
            bOe().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNN() {
        if (bOe() != null) {
            bOe().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gob == null) {
            return false;
        }
        return this.gob.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bOe() != null) {
            bOe().a(this, getProgress());
        }
        bNO();
    }

    public void bNO() {
        if (this.gob == null) {
            bNM();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gob.isLoaded()) {
                this.gob.bNV();
                bNP();
                return;
            }
            bNN();
        }
    }

    private void bNP() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gob.mUrl);
        downloadData.setPath(this.gob.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bNM();
                    return;
                }
                b.this.dAx = downloadData2.getProcess();
                if (b.this.bOe() != null) {
                    b.this.bOe().a(b.this, b.this.getProgress());
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
                    if (!b.this.gob.onResLoaded(downloadData2.getPath())) {
                        b.this.bNM();
                    } else {
                        b.this.bNN();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bNM();
            }
        });
        com.baidu.tbadk.download.d.bwU().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bNQ() {
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
        return this.dAx;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        return isReady();
    }
}
