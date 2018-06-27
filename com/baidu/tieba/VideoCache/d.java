package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class d {
    private long bkO;
    private long currentSize;
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void ig(String str) {
        this.fileName = str;
    }

    public long getAccessTime() {
        return this.bkO;
    }

    public void setAccessTime(long j) {
        this.bkO = j;
    }

    public long PW() {
        return this.currentSize;
    }

    public void az(long j) {
        this.currentSize = j;
    }
}
