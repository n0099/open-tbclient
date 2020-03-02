package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class b implements i {
    private String gjI;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean gjH = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bCn() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bCo() {
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

    public boolean bCp() {
        return this.gjH;
    }

    public void kW(boolean z) {
        this.gjH = z;
    }

    public String bCq() {
        return this.gjI;
    }

    public void AS(String str) {
        this.gjI = str;
    }
}
