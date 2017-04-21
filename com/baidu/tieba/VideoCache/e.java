package com.baidu.tieba.VideoCache;
/* loaded from: classes.dex */
public class e {
    private long aUF;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void gI(String str) {
        this.fileName = str;
    }

    public long Lz() {
        return this.aUF;
    }

    public void an(long j) {
        this.aUF = j;
    }

    public long LA() {
        return this.currentSize;
    }

    public void ao(long j) {
        this.currentSize = j;
    }
}
