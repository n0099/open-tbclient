package com.baidu.tieba.data;

import android.net.Uri;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class WriteData implements Serializable {
    public static final int NEW = 0;
    public static final int REPLY = 1;
    public static final int REPLY_FLOOR = 2;
    public static final String THREAD_TYPE_LBS = "7";
    private static final long serialVersionUID = 3754223209695592335L;
    private boolean isAd;
    private InfoData mBitmapId;
    private List<InfoData> mBitmapIds;
    private List<Uri> mBitmapUris;
    private String mContent;
    private int mDuringTime;
    private String mFloor;
    private int mFloorNum;
    private String mForumId;
    private String mForumName;
    private boolean mHaveDraft;
    private int mPicType;
    private String mThreadId;
    private String mTitle;
    private int mType;
    private String mVcode;
    private String mVcodeMD5;
    private String mVcodeUrl;
    private String mVoiceMd5;

    public WriteData() {
        this.mBitmapUris = null;
        this.mBitmapIds = null;
        this.mType = 0;
        this.mForumId = null;
        this.mForumName = null;
        this.mThreadId = null;
        this.mFloor = null;
        this.mFloorNum = 0;
        this.mTitle = null;
        this.mContent = null;
        this.mVcode = null;
        this.mVcodeMD5 = null;
        this.mVcodeUrl = null;
        this.mBitmapId = null;
        this.mVoiceMd5 = null;
        this.mHaveDraft = false;
        this.mPicType = 0;
        setIsAd(false);
    }

    public WriteData(int i) {
        this.mBitmapUris = null;
        this.mBitmapIds = null;
        this.mType = i;
        this.mTitle = null;
        this.mContent = null;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public void setFloor(String str) {
        this.mFloor = str;
    }

    public String getFloor() {
        return this.mFloor;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void setFloorNum(int i) {
        this.mFloorNum = i;
    }

    public int getFloorNum() {
        return this.mFloorNum;
    }

    public void setVcode(String str) {
        this.mVcode = str;
    }

    public String getVcode() {
        return this.mVcode;
    }

    public void setBitmapId(InfoData infoData) {
        this.mBitmapId = infoData;
    }

    public InfoData getBitmapId() {
        return this.mBitmapId;
    }

    public void setVcodeMD5(String str) {
        this.mVcodeMD5 = str;
    }

    public String getVcodeMD5() {
        return this.mVcodeMD5;
    }

    public String getVcodeUrl() {
        return this.mVcodeUrl;
    }

    public void setVcodeUrl(String str) {
        this.mVcodeUrl = str;
    }

    public void setHaveDraft(boolean z) {
        this.mHaveDraft = z;
    }

    public boolean getHaveDraft() {
        return this.mHaveDraft;
    }

    public void setPicType(int i) {
        this.mPicType = i;
    }

    public int getPicType() {
        return this.mPicType;
    }

    public boolean getIsAd() {
        return this.isAd;
    }

    public void setIsAd(boolean z) {
        this.isAd = z;
    }

    public void setVoice(String str) {
        this.mVoiceMd5 = str;
    }

    public String getVoice() {
        return this.mVoiceMd5;
    }

    public void setVoiceDuringTime(int i) {
        this.mDuringTime = i;
    }

    public int getVoiceDuringTime() {
        return this.mDuringTime;
    }

    public List<Uri> getBitmapUris() {
        return this.mBitmapUris;
    }

    public void setBitmapUris(List<Uri> list) {
        this.mBitmapUris = list;
    }

    public List<InfoData> getBitmapIds() {
        return this.mBitmapIds;
    }

    public void setBitmapIds(List<InfoData> list) {
        this.mBitmapIds = list;
    }
}
