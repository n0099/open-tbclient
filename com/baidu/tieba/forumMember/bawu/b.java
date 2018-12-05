package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dDK = new ArrayList<>();
    private boolean dDL = false;
    private String dDM;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int azi() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> azj() {
        return this.dDK;
    }

    public void M(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dDK = arrayList;
    }

    public boolean isLast() {
        return this.dDL;
    }

    public void gk(boolean z) {
        this.dDL = z;
    }

    public String azk() {
        return this.dDM;
    }

    public void nM(String str) {
        this.dDM = str;
    }
}
