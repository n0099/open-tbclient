package com.baidu.tieba.ad.download;

import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class AdDownloadExtra implements Serializable {
    public final AdDownloadData mAdDownload;
    public int mDownloadFakePercent;
    public String mDownloadFilePath;
    public String mDownloadId;
    public int mPercent;
    public DownloadStatus mState = DownloadStatus.STATUS_NONE;

    public AdDownloadExtra(AdDownloadData adDownloadData) {
        this.mAdDownload = adDownloadData;
    }

    public int getDownloadFakePercent() {
        return this.mDownloadFakePercent;
    }

    public String getDownloadFilePath() {
        return this.mDownloadFilePath;
    }

    public int getPercent() {
        int i = this.mPercent;
        int i2 = this.mDownloadFakePercent;
        return i > i2 ? i : i2;
    }

    public DownloadStatus getStatus() {
        return this.mState;
    }

    public void setDownloadFakePercent(int i) {
        this.mDownloadFakePercent = i;
    }

    public void setDownloadPath(String str) {
        this.mDownloadFilePath = str;
    }

    public void setPercent(int i) {
        this.mPercent = i;
    }

    public void setPercentAndStatus(int i, DownloadStatus downloadStatus) {
        setPercent(i);
        setStatus(downloadStatus);
    }

    public void setStatus(DownloadStatus downloadStatus) {
        this.mState = downloadStatus;
    }
}
