package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes2.dex */
public class a implements TbCheckBox.b {
    private String eDP;
    private String eDQ;
    private String eDR;
    private b eDS;
    private String eDT;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String bpr() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.eDQ != null) {
            sb.append(this.eDQ);
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

    public void fK(String str) {
        this.eDP = str;
    }

    public String bps() {
        return this.eDP;
    }

    public void setQuanpin(String str) {
        this.eDQ = str;
    }

    public String getQuanpin() {
        return this.eDQ;
    }

    public void Bi(String str) {
        this.eDR = str;
    }

    public String bpt() {
        return this.eDR;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.eDP = friendlist.portrait;
            this.eDT = friendlist.name_show;
            this.eDQ = friendlist.quanpin;
            if (friendlist.location == null) {
                this.eDS = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.eDS = new b(friendlist.location.distance, j, i);
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
        return this.eDS;
    }

    public void setLbsInfo(b bVar) {
        this.eDS = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void Bj(String str) {
        this.eDT = str;
    }

    public String bpu() {
        return this.eDT;
    }
}
