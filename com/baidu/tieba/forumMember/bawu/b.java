package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dia = new ArrayList<>();
    private boolean dib = false;
    private String dic;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int asR() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> asS() {
        return this.dia;
    }

    public void M(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dia = arrayList;
    }

    public boolean isLast() {
        return this.dib;
    }

    public void fq(boolean z) {
        this.dib = z;
    }

    public String asT() {
        return this.dic;
    }

    public void mg(String str) {
        this.dic = str;
    }
}
