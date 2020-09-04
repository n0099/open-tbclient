package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes17.dex */
public class b implements i {
    private String hOd;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean hOb = false;
    private boolean hOc = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int ckd() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cke() {
        return this.mMembers;
    }

    public void as(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.hOb;
    }

    public void nW(boolean z) {
        this.hOb = z;
    }

    public boolean ckf() {
        return this.hOc;
    }

    public void nX(boolean z) {
        this.hOc = z;
    }

    public String ckg() {
        return this.hOd;
    }

    public void If(String str) {
        this.hOd = str;
    }
}
