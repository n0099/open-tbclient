package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class l {
    private int mChunkNo;
    private String mMd5;
    private long mTotalLength;

    public String getMd5() {
        return this.mMd5;
    }

    public void setMd5(String str) {
        this.mMd5 = str;
    }

    public long getTotalLength() {
        return this.mTotalLength;
    }

    public void setTotalLength(long j) {
        this.mTotalLength = j;
    }

    public int getChunkNo() {
        return this.mChunkNo;
    }

    public void setChunkNo(int i) {
        this.mChunkNo = i;
    }
}
