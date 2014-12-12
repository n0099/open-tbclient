package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.aj;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class b implements aj {
    private f Er;
    private long Sk;
    private String Sl;
    private String Sm;
    private String Sn;
    private boolean mIsChecked = false;
    private String mUserName;
    private int mUserType;

    public String sV() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.Sm != null) {
            sb.append(this.Sm);
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
        this.Sk = j;
    }

    public long getUserId() {
        return this.Sk;
    }

    public void dB(String str) {
        this.Sl = str;
    }

    public String getUserPortrait() {
        return this.Sl;
    }

    public void setQuanpin(String str) {
        this.Sm = str;
    }

    public String getQuanpin() {
        return this.Sm;
    }

    public void dC(String str) {
        this.Sn = str;
    }

    public String sW() {
        return this.Sn;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.Sk = friendlist.user_id.longValue();
            this.Sl = friendlist.portrait;
            this.Sm = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Er = new f("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Er = new f(friendlist.location.distance, j, i);
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
        return this.Er;
    }

    public void setLbsInfo(f fVar) {
        this.Er = fVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
