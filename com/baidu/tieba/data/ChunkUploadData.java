package com.baidu.tieba.data;
/* loaded from: classes.dex */
public class ChunkUploadData {
    private int mChunkNo;
    private String mMd5;
    private long mTotalLength;

    public String getMd5() {
        return this.mMd5;
    }

    public void setMd5(String md5) {
        this.mMd5 = md5;
    }

    public long getTotalLength() {
        return this.mTotalLength;
    }

    public void setTotalLength(long totalLength) {
        this.mTotalLength = totalLength;
    }

    public int getChunkNo() {
        return this.mChunkNo;
    }

    public void setChunkNo(int chunkNo) {
        this.mChunkNo = chunkNo;
    }
}
