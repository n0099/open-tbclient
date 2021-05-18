package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class PersonChangeData extends OrmObject implements Serializable {
    public static final String TAG_PERSON_INFO = "person_change_data";
    public static final long serialVersionUID = 4345761658406426272L;
    public String cantModifyAvatarDesc;
    public long mAlaId;
    public int mBirthdayShowStatus;
    public long mBirthdayTime;
    public String mTiebaId;
    public int mUserAge;
    public String mForumAge = "0.1";
    public String mIntro = null;
    public int mSex = 0;
    public String mName = null;
    public String mPortrait = null;
    public boolean mPhotoChanged = false;
    public String mNameShow = null;
    public int mNickNameLeftDays = -1;
    public int isMem = 0;
    public boolean canModifyAvatar = true;

    public boolean canModifyAvatar() {
        return this.canModifyAvatar;
    }

    public long getAlaId() {
        return this.mAlaId;
    }

    public int getBirthdayShowStatus() {
        return this.mBirthdayShowStatus;
    }

    public long getBirthdayTime() {
        return this.mBirthdayTime;
    }

    public String getCantModifyAvatarDesc() {
        return this.cantModifyAvatarDesc;
    }

    public String getForumAge() {
        return this.mForumAge;
    }

    public String getIntro() {
        return this.mIntro;
    }

    public int getMen() {
        return this.isMem;
    }

    public String getName() {
        return this.mName;
    }

    public String getNameShow() {
        return this.mNameShow;
    }

    public int getNickNameLeftDays() {
        return this.mNickNameLeftDays;
    }

    public boolean getPhotoChanged() {
        return this.mPhotoChanged;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getSex() {
        return this.mSex;
    }

    public int getUserAge() {
        return this.mUserAge;
    }

    public String getmTiebaId() {
        return this.mTiebaId;
    }

    public void setAlaId(long j) {
        this.mAlaId = j;
    }

    public void setBirthdayShowStatus(int i2) {
        this.mBirthdayShowStatus = i2;
    }

    public void setBirthdayTime(long j) {
        this.mBirthdayTime = j;
    }

    public void setCanModifyAvatar(boolean z) {
        this.canModifyAvatar = z;
    }

    public void setCantModifyAvatarDesc(String str) {
        this.cantModifyAvatarDesc = str;
    }

    public void setForumAge(String str) {
        this.mForumAge = str;
    }

    public void setIntro(String str) {
        this.mIntro = str;
    }

    public void setMem(int i2) {
        this.isMem = i2;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setNameShow(String str) {
        this.mNameShow = str;
    }

    public void setNickNameLeftDays(int i2) {
        this.mNickNameLeftDays = i2;
    }

    public void setPhotoChanged(boolean z) {
        this.mPhotoChanged = z;
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public void setSex(int i2) {
        this.mSex = i2;
    }

    public void setTiebaId(String str) {
        this.mTiebaId = str;
    }

    public void setUserAge(int i2) {
        this.mUserAge = i2;
    }
}
