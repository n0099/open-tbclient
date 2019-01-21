package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dHi = new ArrayList<>();
    private boolean dHj = false;
    private String dHk;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int aAu() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> aAv() {
        return this.dHi;
    }

    public void M(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dHi = arrayList;
    }

    public boolean isLast() {
        return this.dHj;
    }

    public void gp(boolean z) {
        this.dHj = z;
    }

    public String aAw() {
        return this.dHk;
    }

    public void og(String str) {
        this.dHk = str;
    }
}
