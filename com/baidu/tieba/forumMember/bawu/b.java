package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class b implements i {
    private String gTK;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean gTJ = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bMU() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bMV() {
        return this.mMembers;
    }

    public void al(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void mf(boolean z) {
        this.isLast = z;
    }

    public boolean bMW() {
        return this.gTJ;
    }

    public void mg(boolean z) {
        this.gTJ = z;
    }

    public String bMX() {
        return this.gTK;
    }

    public void CF(String str) {
        this.gTK = str;
    }
}
