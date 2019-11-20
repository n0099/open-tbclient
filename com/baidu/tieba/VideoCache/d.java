package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class d {
    private long currentSize;
    private long deN;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void qJ(String str) {
        this.fileName = str;
    }

    public long aCx() {
        return this.deN;
    }

    public void bA(long j) {
        this.deN = j;
    }

    public long aCy() {
        return this.currentSize;
    }

    public void bB(long j) {
        this.currentSize = j;
    }
}
