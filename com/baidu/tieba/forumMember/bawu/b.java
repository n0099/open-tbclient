package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class b implements i {
    private String gkD;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean isLast = false;
    private boolean gkC = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bCu() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bCv() {
        return this.mMembers;
    }

    public void aj(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void la(boolean z) {
        this.isLast = z;
    }

    public boolean bCw() {
        return this.gkC;
    }

    public void lb(boolean z) {
        this.gkC = z;
    }

    public String bCx() {
        return this.gkD;
    }

    public void AV(String str) {
        this.gkD = str;
    }
}
