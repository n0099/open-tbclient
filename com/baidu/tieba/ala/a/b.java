package com.baidu.tieba.ala.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes4.dex */
public class b extends g implements j {
    private d fCZ;
    private String fDa;
    private float cUK = 0.0f;
    private boolean mIsLoading = false;

    public b(String str) {
        this.fDa = str;
        byq();
    }

    private void byq() {
        this.fCZ = c.Cj(this.fDa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPh() {
        if (byG() != null) {
            byG().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byr() {
        if (byG() != null) {
            byG().a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.j
    public boolean isReady() {
        if (this.fCZ == null) {
            return false;
        }
        return this.fCZ.isLoaded();
    }

    @Override // com.baidu.tieba.ala.a.j
    public void load() {
        if (byG() != null) {
            byG().a(this, getProgress());
        }
        bys();
    }

    public void bys() {
        if (this.fCZ == null) {
            aPh();
        } else if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (!this.fCZ.isLoaded()) {
                byt();
            } else {
                byr();
            }
        }
    }

    private void byt() {
        DownloadData downloadData = new DownloadData();
        downloadData.setType(20);
        downloadData.setUrl(this.fCZ.mUrl);
        downloadData.setPath(this.fCZ.getLoadingFile());
        downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.ala.a.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2.getStatus() == 4) {
                    File file = new File(downloadData2.getPath());
                    if (file.exists()) {
                        file.delete();
                    }
                    b.this.aPh();
                    return;
                }
                b.this.cUK = downloadData2.getProcess();
                if (b.this.byG() != null) {
                    b.this.byG().a(b.this, b.this.getProgress());
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
                    if (!b.this.fCZ.onResLoaded(downloadData2.getPath())) {
                        b.this.aPh();
                    } else {
                        b.this.byr();
                    }
                }
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str) {
                File file = new File(downloadData2.getPath());
                if (file.exists()) {
                    file.delete();
                }
                b.this.aPh();
            }
        });
        com.baidu.tbadk.download.d.biF().f(downloadData);
    }

    @Override // com.baidu.tieba.ala.a.j
    public g byu() {
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
        return this.cUK;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gJ() {
        return isReady();
    }
}
