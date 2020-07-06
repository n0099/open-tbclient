package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class b implements i {
    private String huW;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean huV = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bWn() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bWo() {
        return this.mMembers;
    }

    public void al(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void mL(boolean z) {
        this.isLast = z;
    }

    public boolean bWp() {
        return this.huV;
    }

    public void mM(boolean z) {
        this.huV = z;
    }

    public String bWq() {
        return this.huW;
    }

    public void ES(String str) {
        this.huW = str;
    }
}
