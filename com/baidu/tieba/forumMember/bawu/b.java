package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> cTc = new ArrayList<>();
    private boolean cTd = false;
    private String cTe;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int anY() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> anZ() {
        return this.cTc;
    }

    public void H(ArrayList<BawuRoleInfoPub> arrayList) {
        this.cTc = arrayList;
    }

    public boolean isLast() {
        return this.cTd;
    }

    public void fj(boolean z) {
        this.cTd = z;
    }

    public String aoa() {
        return this.cTe;
    }

    public void ly(String str) {
        this.cTe = str;
    }
}
