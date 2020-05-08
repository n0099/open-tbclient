package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String dQb;
    private String dQc;
    private String dQd;
    private b dQe;
    private String dQf;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String aUM() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.dQc != null) {
            sb.append(this.dQc);
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

    public void dK(String str) {
        this.dQb = str;
    }

    public String aUN() {
        return this.dQb;
    }

    public void setQuanpin(String str) {
        this.dQc = str;
    }

    public String getQuanpin() {
        return this.dQc;
    }

    public void vN(String str) {
        this.dQd = str;
    }

    public String aUO() {
        return this.dQd;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.dQb = friendlist.portrait;
            this.dQf = friendlist.name_show;
            this.dQc = friendlist.quanpin;
            if (friendlist.location == null) {
                this.dQe = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.dQe = new b(friendlist.location.distance, j, i);
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
        return this.dQe;
    }

    public void setLbsInfo(b bVar) {
        this.dQe = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void vO(String str) {
        this.dQf = str;
    }

    public String aUP() {
        return this.dQf;
    }
}
