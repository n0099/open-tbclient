package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class d {
    private long cLz;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void qo(String str) {
        this.fileName = str;
    }

    public long avC() {
        return this.cLz;
    }

    public void bt(long j) {
        this.cLz = j;
    }

    public long avD() {
        return this.currentSize;
    }

    public void bu(long j) {
        this.currentSize = j;
    }
}
