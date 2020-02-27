package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String dpC;
    private String dpD;
    private String dpE;
    private b dpF;
    private String dpG;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String aMk() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.dpD != null) {
            sb.append(this.dpD);
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

    public void cV(String str) {
        this.dpC = str;
    }

    public String aMl() {
        return this.dpC;
    }

    public void setQuanpin(String str) {
        this.dpD = str;
    }

    public String getQuanpin() {
        return this.dpD;
    }

    public void uv(String str) {
        this.dpE = str;
    }

    public String aMm() {
        return this.dpE;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.dpC = friendlist.portrait;
            this.dpG = friendlist.name_show;
            this.dpD = friendlist.quanpin;
            if (friendlist.location == null) {
                this.dpF = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.dpF = new b(friendlist.location.distance, j, i);
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
        return this.dpF;
    }

    public void setLbsInfo(b bVar) {
        this.dpF = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void uw(String str) {
        this.dpG = str;
    }

    public String aMn() {
        return this.dpG;
    }
}
