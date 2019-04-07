package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class b implements i {
    private String eUj;
    private ArrayList<BawuRoleInfoPub> eUh = new ArrayList<>();
    private boolean isLast = false;
    private boolean eUi = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int baR() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> baS() {
        return this.eUh;
    }

    public void P(ArrayList<BawuRoleInfoPub> arrayList) {
        this.eUh = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void iL(boolean z) {
        this.isLast = z;
    }

    public boolean baT() {
        return this.eUi;
    }

    public void iM(boolean z) {
        this.eUi = z;
    }

    public String baU() {
        return this.eUj;
    }

    public void uJ(String str) {
        this.eUj = str;
    }
}
