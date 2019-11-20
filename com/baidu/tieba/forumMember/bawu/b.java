package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class b implements i {
    private String fpZ;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean fpY = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bim() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bin() {
        return this.mMembers;
    }

    public void Y(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void ju(boolean z) {
        this.isLast = z;
    }

    public boolean bio() {
        return this.fpY;
    }

    public void jv(boolean z) {
        this.fpY = z;
    }

    public String bip() {
        return this.fpZ;
    }

    public void vA(String str) {
        this.fpZ = str;
    }
}
