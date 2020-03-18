package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String dqd;
    private String dqe;
    private String dqf;
    private b dqg;
    private String dqh;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String aMr() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.dqe != null) {
            sb.append(this.dqe);
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

    public void cU(String str) {
        this.dqd = str;
    }

    public String aMs() {
        return this.dqd;
    }

    public void setQuanpin(String str) {
        this.dqe = str;
    }

    public String getQuanpin() {
        return this.dqe;
    }

    public void uv(String str) {
        this.dqf = str;
    }

    public String aMt() {
        return this.dqf;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.dqd = friendlist.portrait;
            this.dqh = friendlist.name_show;
            this.dqe = friendlist.quanpin;
            if (friendlist.location == null) {
                this.dqg = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.dqg = new b(friendlist.location.distance, j, i);
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
        return this.dqg;
    }

    public void setLbsInfo(b bVar) {
        this.dqg = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void uw(String str) {
        this.dqh = str;
    }

    public String aMu() {
        return this.dqh;
    }
}
