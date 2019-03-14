package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class b implements i {
    private String eUx;
    private ArrayList<BawuRoleInfoPub> eUv = new ArrayList<>();
    private boolean isLast = false;
    private boolean eUw = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int baT() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> baU() {
        return this.eUv;
    }

    public void P(ArrayList<BawuRoleInfoPub> arrayList) {
        this.eUv = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void iL(boolean z) {
        this.isLast = z;
    }

    public boolean baV() {
        return this.eUw;
    }

    public void iM(boolean z) {
        this.eUw = z;
    }

    public String baW() {
        return this.eUx;
    }

    public void uK(String str) {
        this.eUx = str;
    }
}
