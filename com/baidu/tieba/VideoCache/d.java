package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class d {
    private long bbd;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void hB(String str) {
        this.fileName = str;
    }

    public long getAccessTime() {
        return this.bbd;
    }

    public void setAccessTime(long j) {
        this.bbd = j;
    }

    public long Mc() {
        return this.currentSize;
    }

    public void au(long j) {
        this.currentSize = j;
    }
}
