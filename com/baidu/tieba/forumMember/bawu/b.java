package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class b implements i {
    private String fkv;
    private ArrayList<BawuRoleInfoPub> fkt = new ArrayList<>();
    private boolean isLast = false;
    private boolean fku = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bin() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bio() {
        return this.fkt;
    }

    public void T(ArrayList<BawuRoleInfoPub> arrayList) {
        this.fkt = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void jt(boolean z) {
        this.isLast = z;
    }

    public boolean bip() {
        return this.fku;
    }

    public void ju(boolean z) {
        this.fku = z;
    }

    public String biq() {
        return this.fkv;
    }

    public void wc(String str) {
        this.fkv = str;
    }
}
