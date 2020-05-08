package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class b implements i {
    private String gTQ;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean gTP = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bMS() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bMT() {
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

    public boolean bMU() {
        return this.gTP;
    }

    public void mg(boolean z) {
        this.gTP = z;
    }

    public String bMV() {
        return this.gTQ;
    }

    public void CI(String str) {
        this.gTQ = str;
    }
}
