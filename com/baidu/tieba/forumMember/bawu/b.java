package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class b implements i {
    private String fpS;
    private ArrayList<BawuRoleInfoPub> fpQ = new ArrayList<>();
    private boolean isLast = false;
    private boolean fpR = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bkw() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bkx() {
        return this.fpQ;
    }

    public void T(ArrayList<BawuRoleInfoPub> arrayList) {
        this.fpQ = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void jD(boolean z) {
        this.isLast = z;
    }

    public boolean bky() {
        return this.fpR;
    }

    public void jE(boolean z) {
        this.fpR = z;
    }

    public String bkz() {
        return this.fpS;
    }

    public void wI(String str) {
        this.fpS = str;
    }
}
