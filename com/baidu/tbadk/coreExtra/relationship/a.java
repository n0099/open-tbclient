package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.ab;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements ab {
    private b Qg;
    private String acU;
    private long acV;
    private String acW;
    private String acX;
    private String acY;
    private boolean mIsChecked = false;
    private int mUserType;

    public String wI() {
        StringBuilder sb = new StringBuilder(64);
        if (this.acU != null) {
            sb.append(this.acU);
        }
        if (this.acX != null) {
            sb.append(this.acX);
        }
        return sb.toString();
    }

    public void setUserName(String str) {
        this.acU = str;
    }

    public String getUserName() {
        return this.acU;
    }

    public void setUserId(long j) {
        this.acV = j;
    }

    public long getUserId() {
        return this.acV;
    }

    public void dI(String str) {
        this.acW = str;
    }

    public String getUserPortrait() {
        return this.acW;
    }

    public void setQuanpin(String str) {
        this.acX = str;
    }

    public String getQuanpin() {
        return this.acX;
    }

    public void dJ(String str) {
        this.acY = str;
    }

    public String wJ() {
        return this.acY;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.acU = friendlist.user_name;
            this.acV = friendlist.user_id.longValue();
            this.acW = friendlist.portrait;
            this.acX = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Qg = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Qg = new b(friendlist.location.distance, j, i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ab
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.ab
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    public b getLbsInfo() {
        return this.Qg;
    }

    public void setLbsInfo(b bVar) {
        this.Qg = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
