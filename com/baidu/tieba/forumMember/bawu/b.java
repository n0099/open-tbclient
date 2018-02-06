package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dAC = new ArrayList<>();
    private boolean dAD = false;
    private String dAE;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int atJ() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> atK() {
        return this.dAC;
    }

    public void H(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dAC = arrayList;
    }

    public boolean isLast() {
        return this.dAD;
    }

    public void fE(boolean z) {
        this.dAD = z;
    }

    public String atL() {
        return this.dAE;
    }

    public void lv(String str) {
        this.dAE = str;
    }
}
