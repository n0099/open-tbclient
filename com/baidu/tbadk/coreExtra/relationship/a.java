package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String eFZ;
    private String eGa;
    private String eGb;
    private b eGc;
    private String eGd;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String bqm() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.eGa != null) {
            sb.append(this.eGa);
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

    public void fQ(String str) {
        this.eFZ = str;
    }

    public String bqn() {
        return this.eFZ;
    }

    public void setQuanpin(String str) {
        this.eGa = str;
    }

    public String getQuanpin() {
        return this.eGa;
    }

    public void BF(String str) {
        this.eGb = str;
    }

    public String bqo() {
        return this.eGb;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.eFZ = friendlist.portrait;
            this.eGd = friendlist.name_show;
            this.eGa = friendlist.quanpin;
            if (friendlist.location == null) {
                this.eGc = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.eGc = new b(friendlist.location.distance, j, i);
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
        return this.eGc;
    }

    public void setLbsInfo(b bVar) {
        this.eGc = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void BG(String str) {
        this.eGd = str;
    }

    public String bqp() {
        return this.eGd;
    }
}
