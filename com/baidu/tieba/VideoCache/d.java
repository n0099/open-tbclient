package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class d {
    private long bjp;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void ia(String str) {
        this.fileName = str;
    }

    public long getAccessTime() {
        return this.bjp;
    }

    public void setAccessTime(long j) {
        this.bjp = j;
    }

    public long Pz() {
        return this.currentSize;
    }

    public void ay(long j) {
        this.currentSize = j;
    }
}
