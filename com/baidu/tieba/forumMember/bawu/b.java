package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dHh = new ArrayList<>();
    private boolean dHi = false;
    private String dHj;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int aAu() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> aAv() {
        return this.dHh;
    }

    public void M(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dHh = arrayList;
    }

    public boolean isLast() {
        return this.dHi;
    }

    public void gp(boolean z) {
        this.dHi = z;
    }

    public String aAw() {
        return this.dHj;
    }

    public void og(String str) {
        this.dHj = str;
    }
}
