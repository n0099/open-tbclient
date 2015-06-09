package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.ag;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements ag {
    private b QC;
    private String aec;
    private long aed;
    private String aee;
    private String aef;
    private String aeg;
    private boolean mIsChecked = false;
    private int mUserType;

    public String xw() {
        StringBuilder sb = new StringBuilder(64);
        if (this.aec != null) {
            sb.append(this.aec);
        }
        if (this.aef != null) {
            sb.append(this.aef);
        }
        return sb.toString();
    }

    public void setUserName(String str) {
        this.aec = str;
    }

    public String getUserName() {
        return this.aec;
    }

    public void setUserId(long j) {
        this.aed = j;
    }

    public long getUserId() {
        return this.aed;
    }

    public void dZ(String str) {
        this.aee = str;
    }

    public String getUserPortrait() {
        return this.aee;
    }

    public void setQuanpin(String str) {
        this.aef = str;
    }

    public String getQuanpin() {
        return this.aef;
    }

    public void ea(String str) {
        this.aeg = str;
    }

    public String xx() {
        return this.aeg;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.aec = friendlist.user_name;
            this.aed = friendlist.user_id.longValue();
            this.aee = friendlist.portrait;
            this.aef = friendlist.quanpin;
            if (friendlist.location == null) {
                this.QC = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.QC = new b(friendlist.location.distance, j, i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ag
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.ag
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    public b getLbsInfo() {
        return this.QC;
    }

    public void setLbsInfo(b bVar) {
        this.QC = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
