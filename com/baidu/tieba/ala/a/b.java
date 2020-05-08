package com.baidu.tieba.ala.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends g implements j {
    private d eZJ;
    private String eZK;
    private float czE = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.eZK = str;
        bmL();
    }

    private void bmL() {
        this.eZJ = c.zu(this.eZK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aES() {
        if (bnb() != null) {
            bnb().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmM() {
        if (bnb() != null) {
            bnb().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.j
    public boolean isReady() {
        if (this.eZJ == null) {
            return false;
        }
        return this.eZJ.isLoaded();
    }

    @Override // com.baidu.tieba.ala.a.j
    public void load() {
        if (bnb() != null) {
            bnb().a(this, getProgress());
        }
        bmN();
    }

    public void bmN() {
        if (this.eZJ == null) {
            aES();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.eZJ.isLoaded()) {
                bmO();
            } else {
                bmM();
            }
        }
    }

    private void bmO() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.eZJ.mUrl);
        downloadData.setPath(this.eZJ.getLoadingFile());
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
                b.this.czE = downloadData2.getProcess();
                if (b.this.bnb() != null) {
                    b.this.bnb().a(b.this, b.this.getProgress());
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
                    if (!b.this.eZJ.onResLoaded(downloadData2.getPath())) {
                        b.this.aES();
                    } else {
                        b.this.bmM();
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
        com.baidu.tbadk.download.d.aWJ().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.a.j
    public g bmP() {
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
        return this.czE;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gt() {
        return isReady();
    }
}
