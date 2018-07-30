package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String aFL;
    private String aFM;
    private String aFN;
    private b aFO;
    private String aFP;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String Ft() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.aFM != null) {
            sb.append(this.aFM);
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
        this.aFL = str;
    }

    public String Fu() {
        return this.aFL;
    }

    public void setQuanpin(String str) {
        this.aFM = str;
    }

    public String getQuanpin() {
        return this.aFM;
    }

    public void fV(String str) {
        this.aFN = str;
    }

    public String Fv() {
        return this.aFN;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.aFL = friendlist.portrait;
            this.aFP = friendlist.name_show;
            this.aFM = friendlist.quanpin;
            if (friendlist.location == null) {
                this.aFO = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.aFO = new b(friendlist.location.distance, j, i);
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
        return this.aFO;
    }

    public void setLbsInfo(b bVar) {
        this.aFO = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void fW(String str) {
        this.aFP = str;
    }

    public String Fw() {
        return this.aFP;
    }
}
