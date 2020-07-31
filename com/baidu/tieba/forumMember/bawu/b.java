package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes17.dex */
public class b implements i {
    private String hAI;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean hAH = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bZG() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bZH() {
        return this.mMembers;
    }

    public void am(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void nq(boolean z) {
        this.isLast = z;
    }

    public boolean bZI() {
        return this.hAH;
    }

    public void nr(boolean z) {
        this.hAH = z;
    }

    public String bZJ() {
        return this.hAI;
    }

    public void FD(String str) {
        this.hAI = str;
    }
}
