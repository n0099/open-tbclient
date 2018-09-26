package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dnQ = new ArrayList<>();
    private boolean dnR = false;
    private String dnS;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int auE() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> auF() {
        return this.dnQ;
    }

    public void M(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dnQ = arrayList;
    }

    public boolean isLast() {
        return this.dnR;
    }

    public void fH(boolean z) {
        this.dnR = z;
    }

    public String auG() {
        return this.dnS;
    }

    public void mK(String str) {
        this.dnS = str;
    }
}
