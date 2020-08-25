package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes17.dex */
public class b implements i {
    private String hNX;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean hNV = false;
    private boolean hNW = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int ckc() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> ckd() {
        return this.mMembers;
    }

    public void as(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.hNV;
    }

    public void nU(boolean z) {
        this.hNV = z;
    }

    public boolean cke() {
        return this.hNW;
    }

    public void nV(boolean z) {
        this.hNW = z;
    }

    public String ckf() {
        return this.hNX;
    }

    public void Ie(String str) {
        this.hNX = str;
    }
}
