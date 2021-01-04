package com.baidu.tieba.ala.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes10.dex */
public class b extends g implements j {
    private d gNS;
    private String gNT;
    private float dUA = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.gNT = str;
        bVW();
    }

    private void bVW() {
        this.gNS = c.GO(this.gNT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVX() {
        if (bWn() != null) {
            bWn().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVY() {
        if (bWn() != null) {
            bWn().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.j
    public boolean isReady() {
        if (this.gNS == null) {
            return false;
        }
        return this.gNS.isLoaded();
    }

    @Override // com.baidu.tieba.ala.b.j
    public void load() {
        if (bWn() != null) {
            bWn().a(this, getProgress());
        }
        bVZ();
    }

    public void bVZ() {
        if (this.gNS == null) {
            bVX();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.gNS.isLoaded()) {
                this.gNS.bWg();
                bWa();
                return;
            }
            bVY();
        }
    }

    private void bWa() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.gNS.mUrl);
        downloadData.setPath(this.gNS.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.bVX();
                    return;
                }
                b.this.dUA = downloadData2.getProcess();
                if (b.this.bWn() != null) {
                    b.this.bWn().a(b.this, b.this.getProgress());
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
                    if (!b.this.gNS.onResLoaded(downloadData2.getPath())) {
                        b.this.bVX();
                    } else {
                        b.this.bVY();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.bVX();
            }
        });
        com.baidu.tbadk.download.d.bEE().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.b.j
    public g bWb() {
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
        return this.dUA;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean isCompleted() {
        return isReady();
    }
}
