package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class d {
    private long bbc;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void hq(String str) {
        this.fileName = str;
    }

    public long LH() {
        return this.bbc;
    }

    public void au(long j) {
        this.bbc = j;
    }

    public long LI() {
        return this.currentSize;
    }

    public void av(long j) {
        this.currentSize = j;
    }
}
