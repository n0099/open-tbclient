package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends g implements j {
    private d gCg;
    private String gCh;
    private float dLG = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.gCh = str;
        bTr();
    }

    private void bTr() {
        this.gCg = c.GP(this.gCh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTs() {
        if (bTI() != null) {
            bTI().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTt() {
        if (bTI() != null) {
            bTI().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gCg == null) {
            return false;
        }
        return this.gCg.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bTI() != null) {
            bTI().a(this, getProgress());
        }
        bTu();
    }

    public void bTu() {
        if (this.gCg == null) {
            bTs();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gCg.isLoaded()) {
                this.gCg.bTB();
                bTv();
                return;
            }
            bTt();
        }
    }

    private void bTv() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gCg.mUrl);
        downloadData.setPath(this.gCg.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bTs();
                    return;
                }
                b.this.dLG = downloadData2.getProcess();
                if (b.this.bTI() != null) {
                    b.this.bTI().a(b.this, b.this.getProgress());
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
                    if (!b.this.gCg.onResLoaded(downloadData2.getPath())) {
                        b.this.bTs();
                    } else {
                        b.this.bTt();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bTs();
            }
        });
        com.baidu.tbadk.download.d.bCj().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bTw() {
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
