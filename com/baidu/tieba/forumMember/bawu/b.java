package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dfk = new ArrayList<>();
    private boolean dfl = false;
    private String dfm;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int asn() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> aso() {
        return this.dfk;
    }

    public void M(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dfk = arrayList;
    }

    public boolean isLast() {
        return this.dfl;
    }

    public void fp(boolean z) {
        this.dfl = z;
    }

    public String asp() {
        return this.dfm;
    }

    public void mh(String str) {
        this.dfm = str;
    }
}
