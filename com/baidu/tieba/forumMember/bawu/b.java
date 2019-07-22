package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class b implements i {
    private String fpt;
    private ArrayList<BawuRoleInfoPub> fpq = new ArrayList<>();
    private boolean isLast = false;
    private boolean fpr = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bkp() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bkq() {
        return this.fpq;
    }

    public void T(ArrayList<BawuRoleInfoPub> arrayList) {
        this.fpq = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void jD(boolean z) {
        this.isLast = z;
    }

    public boolean bkr() {
        return this.fpr;
    }

    public void jE(boolean z) {
        this.fpr = z;
    }

    public String bks() {
        return this.fpt;
    }

    public void wH(String str) {
        this.fpt = str;
    }
}
