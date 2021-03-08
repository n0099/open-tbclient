package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes7.dex */
public class b implements i {
    private String jdo;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean jdm = false;
    private boolean jdn = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int cAP() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cAQ() {
        return this.mMembers;
    }

    public void ar(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.jdm;
    }

    public void ql(boolean z) {
        this.jdm = z;
    }

    public boolean cAR() {
        return this.jdn;
    }

    public void qm(boolean z) {
        this.jdn = z;
    }

    public String cAS() {
        return this.jdo;
    }

    public void Kd(String str) {
        this.jdo = str;
    }
}
