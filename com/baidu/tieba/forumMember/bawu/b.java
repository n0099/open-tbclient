package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes8.dex */
public class b implements i {
    private String jbF;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean jbD = false;
    private boolean jbE = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int cAJ() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cAK() {
        return this.mMembers;
    }

    public void ar(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.jbD;
    }

    public void ql(boolean z) {
        this.jbD = z;
    }

    public boolean cAL() {
        return this.jbE;
    }

    public void qm(boolean z) {
        this.jbE = z;
    }

    public String cAM() {
        return this.jbF;
    }

    public void JU(String str) {
        this.jbF = str;
    }
}
