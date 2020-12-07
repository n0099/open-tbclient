package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes23.dex */
public class b implements i {
    private String iOe;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean iOc = false;
    private boolean iOd = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int cAo() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cAp() {
        return this.mMembers;
    }

    public void ax(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.iOc;
    }

    public void pI(boolean z) {
        this.iOc = z;
    }

    public boolean cAq() {
        return this.iOd;
    }

    public void pJ(boolean z) {
        this.iOd = z;
    }

    public String cAr() {
        return this.iOe;
    }

    public void Kw(String str) {
        this.iOe = str;
    }
}
