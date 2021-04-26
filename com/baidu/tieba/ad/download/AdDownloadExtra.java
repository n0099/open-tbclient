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
        int i2 = this.mPercent;
        int i3 = this.mDownloadFakePercent;
        return i2 > i3 ? i2 : i3;
    }

    public DownloadStatus getStatus() {
        return this.mState;
    }

    public void setDownloadFakePercent(int i2) {
        this.mDownloadFakePercent = i2;
    }

    public void setDownloadPath(String str) {
        this.mDownloadFilePath = str;
    }

    public void setPercent(int i2) {
        this.mPercent = i2;
    }

    public void setPercentAndStatus(int i2, DownloadStatus downloadStatus) {
        setPercent(i2);
        setStatus(downloadStatus);
    }

    public void setStatus(DownloadStatus downloadStatus) {
        this.mState = downloadStatus;
    }
}
