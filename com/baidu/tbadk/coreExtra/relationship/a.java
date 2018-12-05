package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.TbCheckBox;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements TbCheckBox.b {
    private String aRP;
    private String aRQ;
    private String aRR;
    private b aRS;
    private String aRT;
    private boolean mIsChecked = false;
    private long mUserId;
    private String mUserName;
    private int mUserType;

    public String Ka() {
        StringBuilder sb = new StringBuilder(64);
        if (this.mUserName != null) {
            sb.append(this.mUserName);
        }
        if (this.aRQ != null) {
            sb.append(this.aRQ);
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

    public void gY(String str) {
        this.aRP = str;
    }

    public String Kb() {
        return this.aRP;
    }

    public void setQuanpin(String str) {
        this.aRQ = str;
    }

    public String getQuanpin() {
        return this.aRQ;
    }

    public void gZ(String str) {
        this.aRR = str;
    }

    public String Kc() {
        return this.aRR;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.mUserName = friendlist.user_name;
            this.mUserId = friendlist.user_id.longValue();
            this.aRP = friendlist.portrait;
            this.aRT = friendlist.name_show;
            this.aRQ = friendlist.quanpin;
            if (friendlist.location == null) {
                this.aRS = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.aRS = new b(friendlist.location.distance, j, i);
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
        return this.aRS;
    }

    public void setLbsInfo(b bVar) {
        this.aRS = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public void ha(String str) {
        this.aRT = str;
    }

    public String Kd() {
        return this.aRT;
    }
}
