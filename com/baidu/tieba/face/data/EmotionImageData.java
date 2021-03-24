package com.baidu.tieba.face.data;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class EmotionImageData implements Serializable {
    public String mAuthorNameShow;
    public int mHeight;
    public String mMemeContSign;
    public String mMemeText;
    public String mPicId;
    public String mPicUrl;
    public String mThumbUrl;
    public int mWidth;

    public String getAuthorNameShow() {
        return this.mAuthorNameShow;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getMemeContSign() {
        return this.mMemeContSign;
    }

    public String getMemeText() {
        return this.mMemeText;
    }

    public String getPicId() {
        return this.mPicId;
    }

    public String getPicUrl() {
        return this.mPicUrl;
    }

    public String getThumbUrl() {
        return this.mThumbUrl;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setAuthorNameShow(String str) {
        this.mAuthorNameShow = str;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setMemeContSign(String str) {
        this.mMemeContSign = str;
    }

    public void setMemeText(String str) {
        this.mMemeText = str;
    }

    public void setPicId(String str) {
        this.mPicId = str;
    }

    public void setPicUrl(String str) {
        this.mPicUrl = str;
    }

    public void setThumbUrl(String str) {
        this.mThumbUrl = str;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }
}
