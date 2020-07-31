package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String ets;
    private String ett;
    private String etu;
    private b etv;
    private String etw;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String bgG() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.ett != null) {
            sb.append(this.ett);
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

    public void es(String str) {
        this.ets = str;
    }

    public String bgH() {
        return this.ets;
    }

    public void setQuanpin(String str) {
        this.ett = str;
    }

    public String getQuanpin() {
        return this.ett;
    }

    public void yS(String str) {
        this.etu = str;
    }

    public String bgI() {
        return this.etu;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.ets = friendlist.portrait;
            this.etw = friendlist.name_show;
            this.ett = friendlist.quanpin;
            if (friendlist.location == null) {
                this.etv = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.etv = new b(friendlist.location.distance, j, i);
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
        return this.etv;
    }

    public void setLbsInfo(b bVar) {
        this.etv = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void yT(String str) {
        this.etw = str;
    }

    public String bgJ() {
        return this.etw;
    }
}
