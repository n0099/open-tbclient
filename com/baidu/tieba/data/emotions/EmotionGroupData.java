package com.baidu.tieba.data.emotions;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EmotionGroupData implements Serializable {
    public static final int STATUS_DOWNLOADED = 1;
    public static final int STATUS_DOWNLOADING = 0;
    protected int bytesLength;
    protected int bytesReceived;
    protected long downloadTime;
    protected String downloadUrl;
    protected int emotionsCount;
    protected String groupDesc;
    protected String groupId;
    protected String groupName;
    protected int height;
    protected int status;
    protected int width;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public String getGroupDesc() {
        return this.groupDesc;
    }

    public void setGroupDesc(String str) {
        this.groupDesc = str;
    }

    public int getEmotionsCount() {
        return this.emotionsCount;
    }

    public void setEmotionsCount(int i) {
        this.emotionsCount = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public void setDownloadTime(long j) {
        this.downloadTime = j;
    }

    public int getBytesLength() {
        return this.bytesLength;
    }

    public void setBytesLength(int i) {
        this.bytesLength = i;
    }

    public int getBytesReceived() {
        return this.bytesReceived;
    }

    public void setBytesReceived(int i) {
        this.bytesReceived = i;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }
}
