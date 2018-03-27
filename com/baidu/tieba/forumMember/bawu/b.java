package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dAt = new ArrayList<>();
    private boolean dAu = false;
    private String dAv;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int atJ() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> atK() {
        return this.dAt;
    }

    public void H(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dAt = arrayList;
    }

    public boolean isLast() {
        return this.dAu;
    }

    public void fE(boolean z) {
        this.dAu = z;
    }

    public String atL() {
        return this.dAv;
    }

    public void lv(String str) {
        this.dAv = str;
    }
}
