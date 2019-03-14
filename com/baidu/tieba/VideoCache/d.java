package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class d {
    private long cLx;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void qn(String str) {
        this.fileName = str;
    }

    public long avF() {
        return this.cLx;
    }

    public void bt(long j) {
        this.cLx = j;
    }

    public long avG() {
        return this.currentSize;
    }

    public void bu(long j) {
        this.currentSize = j;
    }
}
