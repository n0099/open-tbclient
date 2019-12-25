package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes7.dex */
public class b implements i {
    private String gew;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean gev = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bzH() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bzI() {
        return this.mMembers;
    }

    public void aj(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void kG(boolean z) {
        this.isLast = z;
    }

    public boolean bzJ() {
        return this.gev;
    }

    public void kH(boolean z) {
        this.gev = z;
    }

    public String bzK() {
        return this.gew;
    }

    public void As(String str) {
        this.gew = str;
    }
}
