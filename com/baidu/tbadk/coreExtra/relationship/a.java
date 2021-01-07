package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String fwL;
    private String fwM;
    private String fwN;
    private b fwO;
    private String fwP;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String bCA() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.fwM != null) {
            sb.append(this.fwM);
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

    public void setUserPortrait(String str) {
        this.fwL = str;
    }

    public String getUserPortrait() {
        return this.fwL;
    }

    public void setQuanpin(String str) {
        this.fwM = str;
    }

    public String getQuanpin() {
        return this.fwM;
    }

    public void Dc(String str) {
        this.fwN = str;
    }

    public String bCB() {
        return this.fwN;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.fwL = friendlist.portrait;
            this.fwP = friendlist.name_show;
            this.fwM = friendlist.quanpin;
            if (friendlist.location == null) {
                this.fwO = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.fwO = new b(friendlist.location.distance, j, i);
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
        return this.fwO;
    }

    public void setLbsInfo(b bVar) {
        this.fwO = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void Dd(String str) {
        this.fwP = str;
    }

    public String bCC() {
        return this.fwP;
    }
}
