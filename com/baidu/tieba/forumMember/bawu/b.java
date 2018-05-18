package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> cUj = new ArrayList<>();
    private boolean cUk = false;
    private String cUl;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int anX() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> anY() {
        return this.cUj;
    }

    public void H(ArrayList<BawuRoleInfoPub> arrayList) {
        this.cUj = arrayList;
    }

    public boolean isLast() {
        return this.cUk;
    }

    public void fk(boolean z) {
        this.cUk = z;
    }

    public String anZ() {
        return this.cUl;
    }

    public void lB(String str) {
        this.cUl = str;
    }
}
