package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes23.dex */
public class b implements i {
    private String iOg;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean iOe = false;
    private boolean iOf = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int cAp() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cAq() {
        return this.mMembers;
    }

    public void ax(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.iOe;
    }

    public void pI(boolean z) {
        this.iOe = z;
    }

    public boolean cAr() {
        return this.iOf;
    }

    public void pJ(boolean z) {
        this.iOf = z;
    }

    public String cAs() {
        return this.iOg;
    }

    public void Kw(String str) {
        this.iOg = str;
    }
}
