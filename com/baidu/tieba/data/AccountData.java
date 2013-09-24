package com.baidu.tieba.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AccountData implements Serializable {
    private static final long serialVersionUID = 4126203103788833116L;
    private String mID = null;
    private String mAccount = null;
    private String mPassword = null;
    private String BDUSS = null;
    private String mTbs = null;
    private int mIsActive = 0;
    private long mTime = 0;

    public String getID() {
        return this.mID;
    }

    public void setID(String str) {
        this.mID = str;
    }

    public String getAccount() {
        return this.mAccount;
    }

    public void setAccount(String str) {
        this.mAccount = str;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public void setPassword(String str) {
        this.mPassword = str;
    }

    public String getBDUSS() {
        return this.BDUSS;
    }

    public void setBDUSS(String str) {
        this.BDUSS = str;
    }

    public int getIsActive() {
        return this.mIsActive;
    }

    public void setIsActive(int i) {
        this.mIsActive = i;
    }

    public void logPrint() {
        com.baidu.tieba.util.av.d(getClass().getName(), "logPrint", "mAccount = " + this.mAccount);
        com.baidu.tieba.util.av.d(getClass().getName(), "logPrint", "mPassword = " + this.mPassword);
        com.baidu.tieba.util.av.d(getClass().getName(), "logPrint", "mIsActive = " + String.valueOf(this.mIsActive));
        com.baidu.tieba.util.av.d(getClass().getName(), "logPrint", "BDUSS = " + this.BDUSS);
    }

    public void setTbs(String str) {
        this.mTbs = str;
    }

    public String getTbs() {
        return this.mTbs;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public long getTime() {
        return this.mTime;
    }
}
