package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String aFK;
    private String aFL;
    private String aFM;
    private b aFN;
    private String aFO;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String Ft() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.aFL != null) {
            sb.append(this.aFL);
        }
        return sb.toString();
    }

    public void setUserName(String str) {
        this.mUserName = str;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public long getUserId() {
        return this.mUserId;
    }

    public void fU(String str) {
        this.aFK = str;
    }

    public String Fu() {
        return this.aFK;
    }

    public void setQuanpin(String str) {
        this.aFL = str;
    }

    public String getQuanpin() {
        return this.aFL;
    }

    public void fV(String str) {
        this.aFM = str;
    }

    public String Fv() {
        return this.aFM;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.aFK = friendlist.portrait;
            this.aFO = friendlist.name_show;
            this.aFL = friendlist.quanpin;
            if (friendlist.location == null) {
                this.aFN = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.aFN = new b(friendlist.location.distance, j, i);
        }
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    public b getLbsInfo() {
        return this.aFN;
    }

    public void setLbsInfo(b bVar) {
        this.aFN = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void fW(String str) {
        this.aFO = str;
    }

    public String Fw() {
        return this.aFO;
    }
}
