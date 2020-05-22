package com.baidu.tieba.ala.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends g implements j {
    private d fmt;
    private String fmu;
    private float cMz = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.fmu = str;
        bsj();
    }

    private void bsj() {
        this.fmt = c.Ba(this.fmu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKn() {
        if (bsz() != null) {
            bsz().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsk() {
        if (bsz() != null) {
            bsz().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.j
    public boolean isReady() {
        if (this.fmt == null) {
            return false;
        }
        return this.fmt.isLoaded();
    }

    @Override // com.baidu.tieba.ala.a.j
    public void load() {
        if (bsz() != null) {
            bsz().a(this, getProgress());
        }
        bsl();
    }

    public void bsl() {
        if (this.fmt == null) {
            aKn();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.fmt.isLoaded()) {
                bsm();
            } else {
                bsk();
            }
        }
    }

    private void bsm() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.fmt.mUrl);
        downloadData.setPath(this.fmt.getLoadingFile());
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
                if (b.this.bsz() != null) {
                    b.this.bsz().a(b.this, b.this.getProgress());
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
                    if (!b.this.fmt.onResLoaded(downloadData2.getPath())) {
                        b.this.aKn();
                    } else {
                        b.this.bsk();
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
        com.baidu.tbadk.download.d.bcT().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.a.j
    public g bsn() {
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
