package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.x;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class b implements x {
    private long Mp;
    private String Mq;
    private String Mr;
    private String Ms;
    private f Mt;
    private boolean mIsChecked = false;
    private String mUserName;

    public String pB() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.Mr != null) {
            sb.append(this.Mr);
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
        this.Mp = j;
    }

    public long getUserId() {
        return this.Mp;
    }

    public void cE(String str) {
        this.Mq = str;
    }

    public String getUserPortrait() {
        return this.Mq;
    }

    public void setQuanpin(String str) {
        this.Mr = str;
    }

    public String getQuanpin() {
        return this.Mr;
    }

    public void cF(String str) {
        this.Ms = str;
    }

    public String pC() {
        return this.Ms;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.Mp = friendlist.user_id.longValue();
            this.Mq = friendlist.portrait;
            this.Mr = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Mt = new f("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Mt = new f(friendlist.location.distance, j, i);
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
        return this.Mt;
    }

    public void setLbsInfo(f fVar) {
        this.Mt = fVar;
    }
}
