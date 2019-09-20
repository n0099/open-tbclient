package com.baidu.tieba.ad.download.state;
/* loaded from: classes3.dex */
public enum DownloadStatus {
    STATUS_NONE(0),
    STATUS_DOWNLOADING(1),
    STATUS_PAUSED(2),
    STATUS_SUCCESS(3),
    STATUS_INSTALL_SUCCESS(4);
    
    public final int status;

    DownloadStatus(int i) {
        this.status = i;
    }

    public static DownloadStatus parse(int i) {
        DownloadStatus[] values;
        for (DownloadStatus downloadStatus : values()) {
            if (downloadStatus.ordinal() == i) {
                return downloadStatus;
            }
        }
        return STATUS_NONE;
    }
}
