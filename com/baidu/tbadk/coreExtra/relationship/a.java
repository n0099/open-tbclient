package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String ffB;
    private String ffC;
    private String ffD;
    private b ffE;
    private String ffF;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String bwF() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.ffC != null) {
            sb.append(this.ffC);
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
        this.ffB = str;
    }

    public String getUserPortrait() {
        return this.ffB;
    }

    public void setQuanpin(String str) {
        this.ffC = str;
    }

    public String getQuanpin() {
        return this.ffC;
    }

    public void Cx(String str) {
        this.ffD = str;
    }

    public String bwG() {
        return this.ffD;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.ffB = friendlist.portrait;
            this.ffF = friendlist.name_show;
            this.ffC = friendlist.quanpin;
            if (friendlist.location == null) {
                this.ffE = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.ffE = new b(friendlist.location.distance, j, i);
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
        return this.ffE;
    }

    public void setLbsInfo(b bVar) {
        this.ffE = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void Cy(String str) {
        this.ffF = str;
    }

    public String bwH() {
        return this.ffF;
    }
}
