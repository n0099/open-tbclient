package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes22.dex */
public class b implements i {
    private String iDm;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean iDk = false;
    private boolean iDl = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int cvZ() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cwa() {
        return this.mMembers;
    }

    public void aw(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.iDk;
    }

    public void pl(boolean z) {
        this.iDk = z;
    }

    public boolean cwb() {
        return this.iDl;
    }

    public void pm(boolean z) {
        this.iDl = z;
    }

    public String cwc() {
        return this.iDm;
    }

    public void JG(String str) {
        this.iDm = str;
    }
}
