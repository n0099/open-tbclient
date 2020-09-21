package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes22.dex */
public class b implements i {
    private String hVd;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean hVb = false;
    private boolean hVc = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int cnq() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cnr() {
        return this.mMembers;
    }

    public void au(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.hVb;
    }

    public void oc(boolean z) {
        this.hVb = z;
    }

    public boolean cns() {
        return this.hVc;
    }

    public void od(boolean z) {
        this.hVc = z;
    }

    public String cnt() {
        return this.hVd;
    }

    public void IC(String str) {
        this.hVd = str;
    }
}
