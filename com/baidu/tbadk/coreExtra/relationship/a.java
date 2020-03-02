package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String dpD;
    private String dpE;
    private String dpF;
    private b dpG;
    private String dpH;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String aMm() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.dpE != null) {
            sb.append(this.dpE);
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
        this.dpD = str;
    }

    public String aMn() {
        return this.dpD;
    }

    public void setQuanpin(String str) {
        this.dpE = str;
    }

    public String getQuanpin() {
        return this.dpE;
    }

    public void uv(String str) {
        this.dpF = str;
    }

    public String aMo() {
        return this.dpF;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.dpD = friendlist.portrait;
            this.dpH = friendlist.name_show;
            this.dpE = friendlist.quanpin;
            if (friendlist.location == null) {
                this.dpG = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.dpG = new b(friendlist.location.distance, j, i);
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
        return this.dpG;
    }

    public void setLbsInfo(b bVar) {
        this.dpG = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void uw(String str) {
        this.dpH = str;
    }

    public String aMp() {
        return this.dpH;
    }
}
