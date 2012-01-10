package com.baidu.tieba.data;
/* loaded from: classes.dex */
public class ChunkUploadResult {
    private ChunkUploadData mData;
    private int mErrorCode;
    private String mErrorString;
    private boolean mIsSuccess;

    public ChunkUploadData getData() {
        return this.mData;
    }

    public void setData(ChunkUploadData data) {
        this.mData = data;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.mIsSuccess = isSuccess;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.mErrorCode = errorCode;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public void setErrorString(String errorString) {
        this.mErrorString = errorString;
    }
}
