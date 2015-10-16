package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private b Vj;
    private String air;
    private String ais;
    private String ait;
    private String aiu;
    private boolean mIsChecked = false;
    private long mUserId;
    private int mUserType;

    public String yw() {
        StringBuilder sb = new StringBuilder(64);
        if (this.air != null) {
            sb.append(this.air);
        }
        if (this.ait != null) {
            sb.append(this.ait);
        }
        return sb.toString();
    }

    public void setUserName(String str) {
        this.air = str;
    }

    public String getUserName() {
        return this.air;
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public long getUserId() {
        return this.mUserId;
    }

    public void em(String str) {
        this.ais = str;
    }

    public String getUserPortrait() {
        return this.ais;
    }

    public void setQuanpin(String str) {
        this.ait = str;
    }

    public String getQuanpin() {
        return this.ait;
    }

    public void en(String str) {
        this.aiu = str;
    }

    public String yx() {
        return this.aiu;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.air = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.ais = friendlist.portrait;
            this.ait = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Vj = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Vj = new b(friendlist.location.distance, j, i);
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
        return this.Vj;
    }

    public void setLbsInfo(b bVar) {
        this.Vj = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
