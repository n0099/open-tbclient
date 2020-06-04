package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class b implements i {
    private String hiN;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean hiM = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bTq() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bTr() {
        return this.mMembers;
    }

    public void al(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void mA(boolean z) {
        this.isLast = z;
    }

    public boolean bTs() {
        return this.hiM;
    }

    public void mB(boolean z) {
        this.hiM = z;
    }

    public String bTt() {
        return this.hiN;
    }

    public void Er(String str) {
        this.hiN = str;
    }
}
