package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class b implements i {
    private String gjG;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean gjF = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bCl() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bCm() {
        return this.mMembers;
    }

    public void aj(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void kV(boolean z) {
        this.isLast = z;
    }

    public boolean bCn() {
        return this.gjF;
    }

    public void kW(boolean z) {
        this.gjF = z;
    }

    public String bCo() {
        return this.gjG;
    }

    public void AS(String str) {
        this.gjG = str;
    }
}
