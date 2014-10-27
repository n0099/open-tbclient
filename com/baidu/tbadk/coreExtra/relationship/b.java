package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.x;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class b implements x {
    private long Mm;
    private String Mn;
    private String Mo;
    private String Mp;
    private f Mq;
    private boolean mIsChecked = false;
    private String mUserName;

    public String pz() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.Mo != null) {
            sb.append(this.Mo);
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
        this.Mm = j;
    }

    public long getUserId() {
        return this.Mm;
    }

    public void cD(String str) {
        this.Mn = str;
    }

    public String getUserPortrait() {
        return this.Mn;
    }

    public void setQuanpin(String str) {
        this.Mo = str;
    }

    public String getQuanpin() {
        return this.Mo;
    }

    public void cE(String str) {
        this.Mp = str;
    }

    public String pA() {
        return this.Mp;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.Mm = friendlist.user_id.longValue();
            this.Mn = friendlist.portrait;
            this.Mo = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Mq = new f("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Mq = new f(friendlist.location.distance, j, i);
        }
    }

    @Override // com.baidu.tbadk.core.view.x
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.x
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    public f getLbsInfo() {
        return this.Mq;
    }

    public void setLbsInfo(f fVar) {
        this.Mq = fVar;
    }
}
