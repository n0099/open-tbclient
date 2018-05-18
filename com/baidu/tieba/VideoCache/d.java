package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class d {
    private long bbe;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void hC(String str) {
        this.fileName = str;
    }

    public long getAccessTime() {
        return this.bbe;
    }

    public void setAccessTime(long j) {
        this.bbe = j;
    }

    public long Ma() {
        return this.currentSize;
    }

    public void au(long j) {
        this.currentSize = j;
    }
}
