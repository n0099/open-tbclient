package com.baidu.tieba.ala.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends g implements j {
    private d fxS;
    private String fxT;
    private float cRj = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.fxT = str;
        bvh();
    }

    private void bvh() {
        this.fxS = c.By(this.fxT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLt() {
        if (bvx() != null) {
            bvx().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvi() {
        if (bvx() != null) {
            bvx().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.j
    public boolean isReady() {
        if (this.fxS == null) {
            return false;
        }
        return this.fxS.isLoaded();
    }

    @Override // com.baidu.tieba.ala.a.j
    public void load() {
        if (bvx() != null) {
            bvx().a(this, getProgress());
        }
        bvj();
    }

    public void bvj() {
        if (this.fxS == null) {
            aLt();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.fxS.isLoaded()) {
                bvk();
            } else {
                bvi();
            }
        }
    }

    private void bvk() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.fxS.mUrl);
        downloadData.setPath(this.fxS.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.a.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.aLt();
                    return;
                }
                b.this.cRj = downloadData2.getProcess();
                if (b.this.bvx() != null) {
                    b.this.bvx().a(b.this, b.this.getProgress());
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
                    if (!b.this.fxS.onResLoaded(downloadData2.getPath())) {
                        b.this.aLt();
                    } else {
                        b.this.bvi();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.aLt();
            }
        });
        com.baidu.tbadk.download.d.beW().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.a.j
    public g bvl() {
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
        return this.cRj;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gJ() {
        return isReady();
    }
}
