package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> ddr = new ArrayList<>();
    private boolean dds = false;
    private String ddt;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int asc() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> asd() {
        return this.ddr;
    }

    public void G(ArrayList<BawuRoleInfoPub> arrayList) {
        this.ddr = arrayList;
    }

    public boolean isLast() {
        return this.dds;
    }

    public void fo(boolean z) {
        this.dds = z;
    }

    public String ase() {
        return this.ddt;
    }

    public void mh(String str) {
        this.ddt = str;
    }
}
