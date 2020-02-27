package com.baidu.tieba.ad.download;

import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class AdDownloadExtra implements Serializable {
    private final AdDownloadData mAdDownload;
    private int mDownloadFakePercent;
    private String mDownloadFilePath;
    public String mDownloadId;
    private int mPercent;
    private DownloadStatus mState = DownloadStatus.STATUS_NONE;

    public AdDownloadExtra(AdDownloadData adDownloadData) {
        this.mAdDownload = adDownloadData;
    }

    public DownloadStatus getStatus() {
        return this.mState;
    }

    public void setStatus(DownloadStatus downloadStatus) {
        this.mState = downloadStatus;
    }

    public int getPercent() {
        return this.mPercent > this.mDownloadFakePercent ? this.mPercent : this.mDownloadFakePercent;
    }

    public void setPercent(int i) {
        this.mPercent = i;
    }

    public void setPercentAndStatus(int i, DownloadStatus downloadStatus) {
        setPercent(i);
        setStatus(downloadStatus);
    }

    public void setDownloadPath(String str) {
        this.mDownloadFilePath = str;
    }

    public String getDownloadFilePath() {
        return this.mDownloadFilePath;
    }

    public void setDownloadFakePercent(int i) {
        this.mDownloadFakePercent = i;
    }

    public int getDownloadFakePercent() {
        return this.mDownloadFakePercent;
    }
}
