package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class PersonChangeData extends OrmObject implements Serializable {
    public static final String TAG_PERSON_INFO = "person_change_data";
    private static final long serialVersionUID = 4345761658406426272L;
    private String cantModifyAvatarDesc;
    private long mAlaId;
    private int mBirthdayShowStatus;
    private long mBirthdayTime;
    private int mUserAge;
    private String mForumAge = "0.1";
    private String mIntro = null;
    private int mSex = 0;
    private String mName = null;
    private String mPortrait = null;
    private boolean mPhotoChanged = false;
    private String mNameShow = null;
    private int mNickNameLeftDays = -1;
    private int isMem = 0;
    private boolean canModifyAvatar = true;

    public int getUserAge() {
        return this.mUserAge;
    }

    public void setUserAge(int i) {
        this.mUserAge = i;
    }

    public String getIntro() {
        return this.mIntro;
    }

    public void setIntro(String str) {
        this.mIntro = str;
    }

    public long getBirthdayTime() {
        return this.mBirthdayTime;
    }

    public void setBirthdayTime(long j) {
        this.mBirthdayTime = j;
    }

    public int getBirthdayShowStatus() {
        return this.mBirthdayShowStatus;
    }

    public void setBirthdayShowStatus(int i) {
        this.mBirthdayShowStatus = i;
    }

    public int getSex() {
        return this.mSex;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setPhotoChanged(boolean z) {
        this.mPhotoChanged = z;
    }

    public boolean getPhotoChanged() {
        return this.mPhotoChanged;
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String getNameShow() {
        return this.mNameShow;
    }

    public void setNameShow(String str) {
        this.mNameShow = str;
    }

    public int getNickNameLeftDays() {
        return this.mNickNameLeftDays;
    }

    public void setNickNameLeftDays(int i) {
        this.mNickNameLeftDays = i;
    }

    public int getMen() {
        return this.isMem;
    }

    public void setMem(int i) {
        this.isMem = i;
    }

    public String getForumAge() {
        return this.mForumAge;
    }

    public void setForumAge(String str) {
        this.mForumAge = str;
    }

    public long getAlaId() {
        return this.mAlaId;
    }

    public void setAlaId(long j) {
        this.mAlaId = j;
    }

    public boolean canModifyAvatar() {
        return this.canModifyAvatar;
    }

    public void setCanModifyAvatar(boolean z) {
        this.canModifyAvatar = z;
    }

    public String getCantModifyAvatarDesc() {
        return this.cantModifyAvatarDesc;
    }

    public void setCantModifyAvatarDesc(String str) {
        this.cantModifyAvatarDesc = str;
    }
}
