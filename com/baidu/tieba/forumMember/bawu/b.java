package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class b implements i {
    private String fku;
    private ArrayList<BawuRoleInfoPub> fks = new ArrayList<>();
    private boolean isLast = false;
    private boolean fkt = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int bik() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> bil() {
        return this.fks;
    }

    public void T(ArrayList<BawuRoleInfoPub> arrayList) {
        this.fks = arrayList;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void jt(boolean z) {
        this.isLast = z;
    }

    public boolean bim() {
        return this.fkt;
    }

    public void ju(boolean z) {
        this.fkt = z;
    }

    public String bin() {
        return this.fku;
    }

    public void wd(String str) {
        this.fku = str;
    }
}
