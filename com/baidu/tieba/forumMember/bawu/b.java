package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class b implements i {
    private String hiC;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean hiB = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bTo() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bTp() {
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

    public boolean bTq() {
        return this.hiB;
    }

    public void mB(boolean z) {
        this.hiB = z;
    }

    public String bTr() {
        return this.hiC;
    }

    public void Er(String str) {
        this.hiC = str;
    }
}
