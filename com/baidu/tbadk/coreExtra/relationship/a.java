package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String dPW;
    private String dPX;
    private String dPY;
    private b dPZ;
    private String dQa;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String aUO() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.dPX != null) {
            sb.append(this.dPX);
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

    public void dK(String str) {
        this.dPW = str;
    }

    public String aUP() {
        return this.dPW;
    }

    public void setQuanpin(String str) {
        this.dPX = str;
    }

    public String getQuanpin() {
        return this.dPX;
    }

    public void vK(String str) {
        this.dPY = str;
    }

    public String aUQ() {
        return this.dPY;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.dPW = friendlist.portrait;
            this.dQa = friendlist.name_show;
            this.dPX = friendlist.quanpin;
            if (friendlist.location == null) {
                this.dPZ = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.dPZ = new b(friendlist.location.distance, j, i);
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
        return this.dPZ;
    }

    public void setLbsInfo(b bVar) {
        this.dPZ = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void vL(String str) {
        this.dQa = str;
    }

    public String aUR() {
        return this.dQa;
    }
}
