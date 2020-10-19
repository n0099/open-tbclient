package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String eSg;
    private String eSh;
    private String eSi;
    private b eSj;
    private String eSk;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String bsW() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.eSh != null) {
            sb.append(this.eSh);
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

    public void ge(String str) {
        this.eSg = str;
    }

    public String bsX() {
        return this.eSg;
    }

    public void setQuanpin(String str) {
        this.eSh = str;
    }

    public String getQuanpin() {
        return this.eSh;
    }

    public void Cr(String str) {
        this.eSi = str;
    }

    public String bsY() {
        return this.eSi;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.eSg = friendlist.portrait;
            this.eSk = friendlist.name_show;
            this.eSh = friendlist.quanpin;
            if (friendlist.location == null) {
                this.eSj = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.eSj = new b(friendlist.location.distance, j, i);
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
        return this.eSj;
    }

    public void setLbsInfo(b bVar) {
        this.eSj = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void Cs(String str) {
        this.eSk = str;
    }

    public String bsZ() {
        return this.eSk;
    }
}
