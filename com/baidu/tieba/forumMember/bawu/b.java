package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes8.dex */
public class b implements i {
    private String ghF;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean ghE = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bAJ() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bAK() {
        return this.mMembers;
    }

    public void aj(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void kR(boolean z) {
        this.isLast = z;
    }

    public boolean bAL() {
        return this.ghE;
    }

    public void kS(boolean z) {
        this.ghE = z;
    }

    public String bAM() {
        return this.ghF;
    }

    public void AC(String str) {
        this.ghF = str;
    }
}
