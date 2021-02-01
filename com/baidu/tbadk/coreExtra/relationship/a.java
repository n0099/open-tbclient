package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String fuu;
    private String fuv;
    private String fuw;
    private b fux;
    private String fuy;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String byY() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.fuv != null) {
            sb.append(this.fuv);
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
        this.fuu = str;
    }

    public String getUserPortrait() {
        return this.fuu;
    }

    public void setQuanpin(String str) {
        this.fuv = str;
    }

    public String getQuanpin() {
        return this.fuv;
    }

    public void Ci(String str) {
        this.fuw = str;
    }

    public String byZ() {
        return this.fuw;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.fuu = friendlist.portrait;
            this.fuy = friendlist.name_show;
            this.fuv = friendlist.quanpin;
            if (friendlist.location == null) {
                this.fux = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.fux = new b(friendlist.location.distance, j, i);
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
        return this.fux;
    }

    public void setLbsInfo(b bVar) {
        this.fux = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void Cj(String str) {
        this.fuy = str;
    }

    public String bza() {
        return this.fuy;
    }
}
