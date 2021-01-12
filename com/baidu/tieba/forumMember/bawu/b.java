package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes7.dex */
public class b implements i {
    private String iVK;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean iVI = false;
    private boolean iVJ = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int czr() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> czs() {
        return this.mMembers;
    }

    public void as(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.iVI;
    }

    public void qb(boolean z) {
        this.iVI = z;
    }

    public boolean czt() {
        return this.iVJ;
    }

    public void qc(boolean z) {
        this.iVJ = z;
    }

    public String czu() {
        return this.iVK;
    }

    public void Ji(String str) {
        this.iVK = str;
    }
}
