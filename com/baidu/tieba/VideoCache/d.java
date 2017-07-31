package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class d {
    private long aWk;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void hj(String str) {
        this.fileName = str;
    }

    public long Ks() {
        return this.aWk;
    }

    public void aq(long j) {
        this.aWk = j;
    }

    public long Kt() {
        return this.currentSize;
    }

    public void ar(long j) {
        this.currentSize = j;
    }
}
