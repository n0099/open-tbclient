package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private b Vp;
    private String ajl;
    private String ajm;
    private String ajn;
    private String ajo;
    private boolean mIsChecked = false;
    private long mUserId;
    private int mUserType;

    public String yF() {
        StringBuilder sb = new StringBuilder(64);
        if (this.ajl != null) {
            sb.append(this.ajl);
        }
        if (this.ajn != null) {
            sb.append(this.ajn);
        }
        return sb.toString();
    }

    public void setUserName(String str) {
        this.ajl = str;
    }

    public String getUserName() {
        return this.ajl;
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public long getUserId() {
        return this.mUserId;
    }

    public void ec(String str) {
        this.ajm = str;
    }

    public String getUserPortrait() {
        return this.ajm;
    }

    public void setQuanpin(String str) {
        this.ajn = str;
    }

    public String getQuanpin() {
        return this.ajn;
    }

    public void ed(String str) {
        this.ajo = str;
    }

    public String yG() {
        return this.ajo;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.ajl = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.ajm = friendlist.portrait;
            this.ajn = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Vp = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Vp = new b(friendlist.location.distance, j, i);
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
        return this.Vp;
    }

    public void setLbsInfo(b bVar) {
        this.Vp = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
