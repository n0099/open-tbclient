package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes23.dex */
public class b implements i {
    private String ikc;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean ika = false;
    private boolean ikb = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int cqO() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cqP() {
        return this.mMembers;
    }

    public void au(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.ika;
    }

    public void oH(boolean z) {
        this.ika = z;
    }

    public boolean cqQ() {
        return this.ikb;
    }

    public void oI(boolean z) {
        this.ikb = z;
    }

    public String cqR() {
        return this.ikc;
    }

    public void Jp(String str) {
        this.ikc = str;
    }
}
