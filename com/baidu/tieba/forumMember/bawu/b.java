package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class b implements i {
    private String gjV;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean gjU = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bCo() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bCp() {
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

    public boolean bCq() {
        return this.gjU;
    }

    public void kW(boolean z) {
        this.gjU = z;
    }

    public String bCr() {
        return this.gjV;
    }

    public void AT(String str) {
        this.gjV = str;
    }
}
