package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.aj;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class b implements aj {
    private f Ev;
    private long SP;
    private String SQ;
    private String SR;
    private String SS;
    private boolean mIsChecked = false;
    private String mUserName;
    private int mUserType;

    public String tm() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.SR != null) {
            sb.append(this.SR);
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
        this.SP = j;
    }

    public long getUserId() {
        return this.SP;
    }

    public void dA(String str) {
        this.SQ = str;
    }

    public String getUserPortrait() {
        return this.SQ;
    }

    public void setQuanpin(String str) {
        this.SR = str;
    }

    public String getQuanpin() {
        return this.SR;
    }

    public void dB(String str) {
        this.SS = str;
    }

    public String tn() {
        return this.SS;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.SP = friendlist.user_id.longValue();
            this.SQ = friendlist.portrait;
            this.SR = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Ev = new f("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Ev = new f(friendlist.location.distance, j, i);
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
        return this.Ev;
    }

    public void setLbsInfo(f fVar) {
        this.Ev = fVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
