package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class b implements i {
    private String frG;
    private ArrayList<BawuRoleInfoPub> frE = new ArrayList<>();
    private boolean isLast = false;
    private boolean frF = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int blh() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bli() {
        return this.frE;
    }

    public void T(ArrayList<BawuRoleInfoPub> arrayList) {
        this.frE = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void jG(boolean z) {
        this.isLast = z;
    }

    public boolean blj() {
        return this.frF;
    }

    public void jH(boolean z) {
        this.frF = z;
    }

    public String blk() {
        return this.frG;
    }

    public void xh(String str) {
        this.frG = str;
    }
}
