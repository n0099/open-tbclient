package com.baidu.tieba.ad.download.state;
/* loaded from: classes4.dex */
public enum DownloadStatus {
    STATUS_NONE(0),
    STATUS_DOWNLOADING(1),
    STATUS_PAUSED(2),
    STATUS_SUCCESS(3),
    STATUS_INSTALL_SUCCESS(4);
    
    public final int status;

    DownloadStatus(int i2) {
        this.status = i2;
    }

    public static DownloadStatus parse(int i2) {
        DownloadStatus[] values;
        for (DownloadStatus downloadStatus : values()) {
            if (downloadStatus.ordinal() == i2) {
                return downloadStatus;
            }
        }
        return STATUS_NONE;
    }
}
