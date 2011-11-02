package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class AccountData {
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

    public void setID(String ID) {
        this.mID = ID;
    }

    public String getAccount() {
        return this.mAccount;
    }

    public void setAccount(String account) {
        this.mAccount = account;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

    public String getBDUSS() {
        return this.BDUSS;
    }

    public void setBDUSS(String bDUSS) {
        this.BDUSS = bDUSS;
    }

    public int getIsActive() {
        return this.mIsActive;
    }

    public void setIsActive(int isActive) {
        this.mIsActive = isActive;
    }

    public void logPrint() {
        TiebaLog.v(getClass().getName(), "logPrint", "mAccount = " + this.mAccount);
        TiebaLog.v(getClass().getName(), "logPrint", "mPassword = " + this.mPassword);
        TiebaLog.v(getClass().getName(), "logPrint", "mIsActive = " + String.valueOf(this.mIsActive));
        TiebaLog.v(getClass().getName(), "logPrint", "BDUSS = " + this.BDUSS);
    }

    public void setTbs(String tbs) {
        this.mTbs = tbs;
    }

    public String getTbs() {
        return this.mTbs;
    }

    public void setTime(long time) {
        this.mTime = time;
    }

    public long getTime() {
        return this.mTime;
    }
}
