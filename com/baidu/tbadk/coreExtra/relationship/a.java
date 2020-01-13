package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String dlu;
    private String dlv;
    private String dlw;
    private b dlx;
    private String dly;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String aJQ() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.dlv != null) {
            sb.append(this.dlv);
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

    public void cM(String str) {
        this.dlu = str;
    }

    public String aJR() {
        return this.dlu;
    }

    public void setQuanpin(String str) {
        this.dlv = str;
    }

    public String getQuanpin() {
        return this.dlv;
    }

    public void ue(String str) {
        this.dlw = str;
    }

    public String aJS() {
        return this.dlw;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.dlu = friendlist.portrait;
            this.dly = friendlist.name_show;
            this.dlv = friendlist.quanpin;
            if (friendlist.location == null) {
                this.dlx = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.dlx = new b(friendlist.location.distance, j, i);
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
        return this.dlx;
    }

    public void setLbsInfo(b bVar) {
        this.dlx = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void uf(String str) {
        this.dly = str;
    }

    public String aJT() {
        return this.dly;
    }
}
