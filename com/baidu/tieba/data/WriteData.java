package com.baidu.tieba.data;

import com.baidu.tieba.model.WriteModel;
/* loaded from: classes.dex */
public class WriteData extends WriteModel {
    public static final int LBS = 3;
    public static final int LBS_REPLY = 4;
    public static final int NEW = 0;
    public static final int REPLY = 1;
    public static final int REPLY_FLOOR = 2;
    private static final long serialVersionUID = 1;
    private int mType = 1;
    private String mForumId = null;
    private String mForumName = null;
    private String mThreadId = null;
    private String mFloor = null;
    private int mFloorNum = 1;
    private String mTitle = null;
    private String mContent = null;
    private String mVcode = null;
    private String mVcodeMD5 = null;
    private String mVcodeUrl = null;
    private boolean mHaveDraft = false;
    private InfoData mBitmapId = null;
    private int mPicType = 0;
    private boolean isAd = false;

    public boolean getIsAd() {
        return this.isAd;
    }

    public void setIsAd(boolean z) {
        this.isAd = z;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public int getType() {
        return this.mType;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setType(int i) {
        this.mType = i;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public String getContent() {
        return this.mContent;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setContent(String str) {
        this.mContent = str;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public String getThreadId() {
        return this.mThreadId;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setFloor(String str) {
        this.mFloor = str;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public String getFloor() {
        return this.mFloor;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public String getForumId() {
        return this.mForumId;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public String getForumName() {
        return this.mForumName;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setFloorNum(int i) {
        this.mFloorNum = i;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public int getFloorNum() {
        return this.mFloorNum;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setVcode(String str) {
        this.mVcode = str;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public String getVcode() {
        return this.mVcode;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setBitmapId(InfoData infoData) {
        this.mBitmapId = infoData;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public InfoData getBitmapId() {
        return this.mBitmapId;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setVcodeMD5(String str) {
        this.mVcodeMD5 = str;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public String getVcodeMD5() {
        return this.mVcodeMD5;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public String getVcodeUrl() {
        return this.mVcodeUrl;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setVcodeUrl(String str) {
        this.mVcodeUrl = str;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setHaveDraft(boolean z) {
        this.mHaveDraft = z;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public boolean getHaveDraft() {
        return this.mHaveDraft;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public void setPicType(int i) {
        this.mPicType = i;
    }

    @Override // com.baidu.tieba.model.WriteModel
    public int getPicType() {
        return this.mPicType;
    }
}
