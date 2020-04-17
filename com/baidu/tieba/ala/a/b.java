package com.baidu.tieba.ala.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends g implements j {
    private d eZE;
    private String eZF;
    private float czy = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.eZF = str;
        bmN();
    }

    private void bmN() {
        this.eZE = c.zr(this.eZF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aES() {
        if (bnd() != null) {
            bnd().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmO() {
        if (bnd() != null) {
            bnd().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.j
    public boolean isReady() {
        if (this.eZE == null) {
            return false;
        }
        return this.eZE.isLoaded();
    }

    @Override // com.baidu.tieba.ala.a.j
    public void load() {
        if (bnd() != null) {
            bnd().a(this, getProgress());
        }
        bmP();
    }

    public void bmP() {
        if (this.eZE == null) {
            aES();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.eZE.isLoaded()) {
                bmQ();
            } else {
                bmO();
            }
        }
    }

    private void bmQ() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.eZE.mUrl);
        downloadData.setPath(this.eZE.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.a.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.aES();
                    return;
                }
                b.this.czy = downloadData2.getProcess();
                if (b.this.bnd() != null) {
                    b.this.bnd().a(b.this, b.this.getProgress());
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
                    if (!b.this.eZE.onResLoaded(downloadData2.getPath())) {
                        b.this.aES();
                    } else {
                        b.this.bmO();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.aES();
            }
        });
        com.baidu.tbadk.download.d.aWL().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.a.j
    public g bmR() {
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
        return this.czy;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gt() {
        return isReady();
    }
}
