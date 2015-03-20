package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.tbadk.core.view.ab;
import tbclient.GetAddressList.friendList;
/* loaded from: classes.dex */
public class a implements ab {
    private b Qe;
    private String acM;
    private long acN;
    private String acO;
    private String acP;
    private String acQ;
    private boolean mIsChecked = false;
    private int mUserType;

    public String wC() {
        StringBuilder sb = new StringBuilder(64);
        if (this.acM != null) {
            sb.append(this.acM);
        }
        if (this.acP != null) {
            sb.append(this.acP);
        }
        return sb.toString();
    }

    public void setUserName(String str) {
        this.acM = str;
    }

    public String getUserName() {
        return this.acM;
    }

    public void setUserId(long j) {
        this.acN = j;
    }

    public long getUserId() {
        return this.acN;
    }

    public void dF(String str) {
        this.acO = str;
    }

    public String getUserPortrait() {
        return this.acO;
    }

    public void setQuanpin(String str) {
        this.acP = str;
    }

    public String getQuanpin() {
        return this.acP;
    }

    public void dG(String str) {
        this.acQ = str;
    }

    public String wD() {
        return this.acQ;
    }

    public void a(friendList friendlist) {
        int i = -1;
        long j = 0;
        if (friendlist != null) {
            this.acM = friendlist.user_name;
            this.acN = friendlist.user_id.longValue();
            this.acO = friendlist.portrait;
            this.acP = friendlist.quanpin;
            if (friendlist.location == null) {
                this.Qe = new b("", 0L, -1);
                return;
            }
            if (friendlist.location.time != null && friendlist.location.time.longValue() > 0) {
                j = friendlist.location.time.longValue();
            }
            if (friendlist.location.is_hide != null && friendlist.location.is_hide.intValue() >= 0) {
                i = friendlist.location.is_hide.intValue();
            }
            this.Qe = new b(friendlist.location.distance, j, i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ab
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.ab
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    public b getLbsInfo() {
        return this.Qe;
    }

    public void setLbsInfo(b bVar) {
        this.Qe = bVar;
    }

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }
}
