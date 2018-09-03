package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dhY = new ArrayList<>();
    private boolean dhZ = false;
    private String dia;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int asQ() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> asR() {
        return this.dhY;
    }

    public void M(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dhY = arrayList;
    }

    public boolean isLast() {
        return this.dhZ;
    }

    public void fq(boolean z) {
        this.dhZ = z;
    }

    public String asS() {
        return this.dia;
    }

    public void mi(String str) {
        this.dia = str;
    }
}
