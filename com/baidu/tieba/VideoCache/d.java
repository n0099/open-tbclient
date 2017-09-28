package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class d {
    private long aXH;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void hf(String str) {
        this.fileName = str;
    }

    public long KT() {
        return this.aXH;
    }

    public void ap(long j) {
        this.aXH = j;
    }

    public long KU() {
        return this.currentSize;
    }

    public void aq(long j) {
        this.currentSize = j;
    }
}
