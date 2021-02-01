package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes8.dex */
public class b implements i {
    private String jbr;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean jbp = false;
    private boolean jbq = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int cAC() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cAD() {
        return this.mMembers;
    }

    public void ar(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.jbp;
    }

    public void ql(boolean z) {
        this.jbp = z;
    }

    public boolean cAE() {
        return this.jbq;
    }

    public void qm(boolean z) {
        this.jbq = z;
    }

    public String cAF() {
        return this.jbr;
    }

    public void JT(String str) {
        this.jbr = str;
    }
}
