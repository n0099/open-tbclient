package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String aul;
    private String aum;
    private String aun;
    private b auo;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String AR() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.aum != null) {
            sb.append(this.aum);
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

    public void fa(String str) {
        this.aul = str;
    }

    public String AS() {
        return this.aul;
    }

    public void setQuanpin(String str) {
        this.aum = str;
    }

    public String getQuanpin() {
        return this.aum;
    }

    public void fb(String str) {
        this.aun = str;
    }

    public String AT() {
        return this.aun;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.aul = friendlist.portrait;
            this.aum = friendlist.quanpin;
            if (friendlist.location == null) {
                this.auo = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.auo = new b(friendlist.location.distance, j, i);
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
        return this.auo;
    }

    public void setLbsInfo(b bVar) {
        this.auo = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
