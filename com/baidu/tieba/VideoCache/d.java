package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class d {
    private long aWm;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void hm(String str) {
        this.fileName = str;
    }

    public long Ks() {
        return this.aWm;
    }

    public void aq(long j) {
        this.aWm = j;
    }

    public long Kt() {
        return this.currentSize;
    }

    public void ar(long j) {
        this.currentSize = j;
    }
}
