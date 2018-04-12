package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> cTf = new ArrayList<>();
    private boolean cTg = false;
    private String cTh;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int anY() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> anZ() {
        return this.cTf;
    }

    public void H(ArrayList<BawuRoleInfoPub> arrayList) {
        this.cTf = arrayList;
    }

    public boolean isLast() {
        return this.cTg;
    }

    public void fj(boolean z) {
        this.cTg = z;
    }

    public String aoa() {
        return this.cTh;
    }

    public void ly(String str) {
        this.cTh = str;
    }
}
