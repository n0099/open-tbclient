package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String fnb;
    private String fnc;
    private String fnd;
    private b fne;
    private String fnf;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String bAf() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.fnc != null) {
            sb.append(this.fnc);
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

    public void setUserPortrait(String str) {
        this.fnb = str;
    }

    public String getUserPortrait() {
        return this.fnb;
    }

    public void setQuanpin(String str) {
        this.fnc = str;
    }

    public String getQuanpin() {
        return this.fnc;
    }

    public void Df(String str) {
        this.fnd = str;
    }

    public String bAg() {
        return this.fnd;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.fnb = friendlist.portrait;
            this.fnf = friendlist.name_show;
            this.fnc = friendlist.quanpin;
            if (friendlist.location == null) {
                this.fne = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.fne = new b(friendlist.location.distance, j, i);
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
        return this.fne;
    }

    public void setLbsInfo(b bVar) {
        this.fne = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void Dg(String str) {
        this.fnf = str;
    }

    public String bAh() {
        return this.fnf;
    }
}
