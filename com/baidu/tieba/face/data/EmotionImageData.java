package com.baidu.tieba.face.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EmotionImageData implements Serializable {
    private String mAuthorNameShow;
    private int mHeight;
    private String mMemeContSign;
    private String mMemeText;
    private String mPicId;
    private String mPicUrl;
    private String mThumbUrl;
    private int mWidth;

    public String getMemeContSign() {
        return this.mMemeContSign;
    }

    public void setMemeContSign(String str) {
        this.mMemeContSign = str;
    }

    public String getMemeText() {
        return this.mMemeText;
    }

    public void setMemeText(String str) {
        this.mMemeText = str;
    }

    public String getPicId() {
        return this.mPicId;
    }

    public void setPicId(String str) {
        this.mPicId = str;
    }

    public String getPicUrl() {
        return this.mPicUrl;
    }

    public void setPicUrl(String str) {
        this.mPicUrl = str;
    }

    public String getThumbUrl() {
        return this.mThumbUrl;
    }

    public void setThumbUrl(String str) {
        this.mThumbUrl = str;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public String getAuthorNameShow() {
        return this.mAuthorNameShow;
    }

    public void setAuthorNameShow(String str) {
        this.mAuthorNameShow = str;
    }
}
