package com.baidu.tieba.faceshop;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class EmotionGroupData implements Serializable {
    public static final int STATUS_DOWNLOADED = 1;
    public static final int STATUS_DOWNLOADING = 0;
    public static final long serialVersionUID = 1;
    public int bytesLength;
    public int bytesReceived;
    public long downloadTime;
    public String downloadUrl;
    public int emotionsCount;
    public String groupDesc;
    public String groupId;
    public String groupName;
    public int height;
    public int status;
    public int width;

    public int getBytesLength() {
        return this.bytesLength;
    }

    public int getBytesReceived() {
        return this.bytesReceived;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getEmotionsCount() {
        return this.emotionsCount;
    }

    public String getGroupDesc() {
        return this.groupDesc;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getHeight() {
        return this.height;
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBytesLength(int i2) {
        this.bytesLength = i2;
    }

    public void setBytesReceived(int i2) {
        this.bytesReceived = i2;
    }

    public void setDownloadTime(long j) {
        this.downloadTime = j;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setEmotionsCount(int i2) {
        this.emotionsCount = i2;
    }

    public void setGroupDesc(String str) {
        this.groupDesc = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }
}
