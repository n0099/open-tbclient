package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes8.dex */
public class b implements i {
    private String jar;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean jap = false;
    private boolean jaq = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int cDi() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cDj() {
        return this.mMembers;
    }

    public void ax(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.jap;
    }

    public void qf(boolean z) {
        this.jap = z;
    }

    public boolean cDk() {
        return this.jaq;
    }

    public void qg(boolean z) {
        this.jaq = z;
    }

    public String cDl() {
        return this.jar;
    }

    public void Ku(String str) {
        this.jar = str;
    }
}
