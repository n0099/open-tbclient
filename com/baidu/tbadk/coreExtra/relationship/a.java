package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String fgt;
    private String fgu;
    private String fgv;
    private b fgw;
    private String fgx;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String bxp() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.fgu != null) {
            sb.append(this.fgu);
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
        this.fgt = str;
    }

    public String getUserPortrait() {
        return this.fgt;
    }

    public void setQuanpin(String str) {
        this.fgu = str;
    }

    public String getQuanpin() {
        return this.fgu;
    }

    public void CY(String str) {
        this.fgv = str;
    }

    public String bxq() {
        return this.fgv;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.fgt = friendlist.portrait;
            this.fgx = friendlist.name_show;
            this.fgu = friendlist.quanpin;
            if (friendlist.location == null) {
                this.fgw = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.fgw = new b(friendlist.location.distance, j, i);
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
        return this.fgw;
    }

    public void setLbsInfo(b bVar) {
        this.fgw = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void CZ(String str) {
        this.fgx = str;
    }

    public String bxr() {
        return this.fgx;
    }
}
