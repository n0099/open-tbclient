package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private b Vs;
    private String aju;
    private String ajv;
    private String ajw;
    private String ajx;
    private boolean mIsChecked = false;
    private long mUserId;
    private int mUserType;

    public String yM() {
        StringBuilder sb = new StringBuilder(64);
        if (this.aju != null) {
            sb.append(this.aju);
        }
        if (this.ajw != null) {
            sb.append(this.ajw);
        }
        return sb.toString();
    }

    public void setUserName(String str) {
        this.aju = str;
    }

    public String getUserName() {
        return this.aju;
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public long getUserId() {
        return this.mUserId;
    }

    public void ej(String str) {
        this.ajv = str;
    }

    public String getUserPortrait() {
        return this.ajv;
    }

    public void setQuanpin(String str) {
        this.ajw = str;
    }

    public String getQuanpin() {
        return this.ajw;
    }

    public void ek(String str) {
        this.ajx = str;
    }

    public String yN() {
        return this.ajx;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.aju = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.ajv = friendlist.portrait;
            this.ajw = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Vs = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Vs = new b(friendlist.location.distance, j, i);
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
        return this.Vs;
    }

    public void setLbsInfo(b bVar) {
        this.Vs = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
