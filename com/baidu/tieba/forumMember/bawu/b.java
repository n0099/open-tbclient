package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class b implements i {
    private String fqQ;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean fqP = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bio() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bip() {
        return this.mMembers;
    }

    public void Y(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void ju(boolean z) {
        this.isLast = z;
    }

    public boolean biq() {
        return this.fqP;
    }

    public void jv(boolean z) {
        this.fqP = z;
    }

    public String bir() {
        return this.fqQ;
    }

    public void vA(String str) {
        this.fqQ = str;
    }
}
