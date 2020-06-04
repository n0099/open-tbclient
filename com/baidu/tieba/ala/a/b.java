package com.baidu.tieba.ala.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends g implements j {
    private d fmE;
    private String fmF;
    private float cMz = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.fmF = str;
        bsl();
    }

    private void bsl() {
        this.fmE = c.Ba(this.fmF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKn() {
        if (bsB() != null) {
            bsB().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsm() {
        if (bsB() != null) {
            bsB().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.j
    public boolean isReady() {
        if (this.fmE == null) {
            return false;
        }
        return this.fmE.isLoaded();
    }

    @Override // com.baidu.tieba.ala.a.j
    public void load() {
        if (bsB() != null) {
            bsB().a(this, getProgress());
        }
        bsn();
    }

    public void bsn() {
        if (this.fmE == null) {
            aKn();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.fmE.isLoaded()) {
                bso();
            } else {
                bsm();
            }
        }
    }

    private void bso() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.fmE.mUrl);
        downloadData.setPath(this.fmE.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.a.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.aKn();
                    return;
                }
                b.this.cMz = downloadData2.getProcess();
                if (b.this.bsB() != null) {
                    b.this.bsB().a(b.this, b.this.getProgress());
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
                    if (!b.this.fmE.onResLoaded(downloadData2.getPath())) {
                        b.this.aKn();
                    } else {
                        b.this.bsm();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.aKn();
            }
        });
        com.baidu.tbadk.download.d.bcU().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.a.j
    public g bsp() {
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
        return this.cMz;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gt() {
        return isReady();
    }
}
