package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class b implements i {
    private String eUk;
    private ArrayList<BawuRoleInfoPub> eUi = new ArrayList<>();
    private boolean isLast = false;
    private boolean eUj = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int baR() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> baS() {
        return this.eUi;
    }

    public void P(ArrayList<BawuRoleInfoPub> arrayList) {
        this.eUi = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void iL(boolean z) {
        this.isLast = z;
    }

    public boolean baT() {
        return this.eUj;
    }

    public void iM(boolean z) {
        this.eUj = z;
    }

    public String baU() {
        return this.eUk;
    }

    public void uJ(String str) {
        this.eUk = str;
    }
}
