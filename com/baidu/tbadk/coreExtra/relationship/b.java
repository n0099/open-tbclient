package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.aj;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class b implements aj {
    private f Es;
    private long SL;
    private String SM;
    private String SO;
    private String SP;
    private boolean mIsChecked = false;
    private String mUserName;
    private int mUserType;

    public String tg() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.SO != null) {
            sb.append(this.SO);
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
        this.SL = j;
    }

    public long getUserId() {
        return this.SL;
    }

    public void dx(String str) {
        this.SM = str;
    }

    public String getUserPortrait() {
        return this.SM;
    }

    public void setQuanpin(String str) {
        this.SO = str;
    }

    public String getQuanpin() {
        return this.SO;
    }

    public void dy(String str) {
        this.SP = str;
    }

    public String th() {
        return this.SP;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.SL = friendlist.user_id.longValue();
            this.SM = friendlist.portrait;
            this.SO = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Es = new f("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Es = new f(friendlist.location.distance, j, i);
        }
    }

    @Override // com.baidu.tbadk.core.view.aj
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    public f getLbsInfo() {
        return this.Es;
    }

    public void setLbsInfo(f fVar) {
        this.Es = fVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
