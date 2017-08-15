package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class d {
    private long aWl;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void hj(String str) {
        this.fileName = str;
    }

    public long Ks() {
        return this.aWl;
    }

    public void aq(long j) {
        this.aWl = j;
    }

    public long Kt() {
        return this.currentSize;
    }

    public void ar(long j) {
        this.currentSize = j;
    }
}
