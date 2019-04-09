package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String cbd;
    private String cbe;
    private String cbf;
    private b cbg;
    private String cbh;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String ajK() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.cbe != null) {
            sb.append(this.cbe);
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

    public void nZ(String str) {
        this.cbd = str;
    }

    public String ajL() {
        return this.cbd;
    }

    public void setQuanpin(String str) {
        this.cbe = str;
    }

    public String getQuanpin() {
        return this.cbe;
    }

    public void oa(String str) {
        this.cbf = str;
    }

    public String ajM() {
        return this.cbf;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.cbd = friendlist.portrait;
            this.cbh = friendlist.name_show;
            this.cbe = friendlist.quanpin;
            if (friendlist.location == null) {
                this.cbg = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.cbg = new b(friendlist.location.distance, j, i);
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
        return this.cbg;
    }

    public void setLbsInfo(b bVar) {
        this.cbg = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void ob(String str) {
        this.cbh = str;
    }

    public String ajN() {
        return this.cbh;
    }
}
