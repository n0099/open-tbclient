package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class d {
    private long cWj;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void rZ(String str) {
        this.fileName = str;
    }

    public long aCq() {
        return this.cWj;
    }

    public void bM(long j) {
        this.cWj = j;
    }

    public long aCr() {
        return this.currentSize;
    }

    public void bN(long j) {
        this.currentSize = j;
    }
}
