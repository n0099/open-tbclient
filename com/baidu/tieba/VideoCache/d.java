package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class d {
    private long cTM;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void rx(String str) {
        this.fileName = str;
    }

    public long aAL() {
        return this.cTM;
    }

    public void bI(long j) {
        this.cTM = j;
    }

    public long aAM() {
        return this.currentSize;
    }

    public void bJ(long j) {
        this.currentSize = j;
    }
}
