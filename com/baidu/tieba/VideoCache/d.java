package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class d {
    private long currentSize;
    private long dfE;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void qJ(String str) {
        this.fileName = str;
    }

    public long aCz() {
        return this.dfE;
    }

    public void bB(long j) {
        this.dfE = j;
    }

    public long aCA() {
        return this.currentSize;
    }

    public void bC(long j) {
        this.currentSize = j;
    }
}
