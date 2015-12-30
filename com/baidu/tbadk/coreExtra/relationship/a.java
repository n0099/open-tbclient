package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private b Wq;
    private String alq;
    private String alr;
    private String als;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String zg() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.alr != null) {
            sb.append(this.alr);
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

    public void ey(String str) {
        this.alq = str;
    }

    public String getUserPortrait() {
        return this.alq;
    }

    public void setQuanpin(String str) {
        this.alr = str;
    }

    public String getQuanpin() {
        return this.alr;
    }

    public void ez(String str) {
        this.als = str;
    }

    public String zh() {
        return this.als;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.alq = friendlist.portrait;
            this.alr = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Wq = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Wq = new b(friendlist.location.distance, j, i);
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
        return this.Wq;
    }

    public void setLbsInfo(b bVar) {
        this.Wq = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
