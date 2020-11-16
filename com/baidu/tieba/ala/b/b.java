package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends g implements j {
    private d gtv;
    private String gtw;
    private float dEI = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.gtw = str;
        bPE();
    }

    private void bPE() {
        this.gtv = c.Gb(this.gtw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPF() {
        if (bPX() != null) {
            bPX().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPG() {
        if (bPX() != null) {
            bPX().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gtv == null) {
            return false;
        }
        return this.gtv.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bPX() != null) {
            bPX().a(this, getProgress());
        }
        bPH();
    }

    public void bPH() {
        if (this.gtv == null) {
            bPF();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gtv.isLoaded()) {
                this.gtv.bPO();
                bPI();
                return;
            }
            bPG();
        }
    }

    private void bPI() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gtv.mUrl);
        downloadData.setPath(this.gtv.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bPF();
                    return;
                }
                b.this.dEI = downloadData2.getProcess();
                if (b.this.bPX() != null) {
                    b.this.bPX().a(b.this, b.this.getProgress());
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
                    if (!b.this.gtv.onResLoaded(downloadData2.getPath())) {
                        b.this.bPF();
                    } else {
                        b.this.bPG();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bPF();
            }
        });
        com.baidu.tbadk.download.d.byJ().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bPJ() {
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
        return this.dEI;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        return isReady();
    }
}
