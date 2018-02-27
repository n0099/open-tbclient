package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dAq = new ArrayList<>();
    private boolean dAr = false;
    private String dAs;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int atI() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> atJ() {
        return this.dAq;
    }

    public void H(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dAq = arrayList;
    }

    public boolean isLast() {
        return this.dAr;
    }

    public void fE(boolean z) {
        this.dAr = z;
    }

    public String atK() {
        return this.dAs;
    }

    public void lv(String str) {
        this.dAs = str;
    }
}
