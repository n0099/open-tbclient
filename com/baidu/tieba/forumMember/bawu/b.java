package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dvT = new ArrayList<>();
    private boolean dvU = false;
    private String dvV;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int ayb() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> ayc() {
        return this.dvT;
    }

    public void M(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dvT = arrayList;
    }

    public boolean isLast() {
        return this.dvU;
    }

    public void fZ(boolean z) {
        this.dvU = z;
    }

    public String ayd() {
        return this.dvV;
    }

    public void nm(String str) {
        this.dvV = str;
    }
}
