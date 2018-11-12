package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private ArrayList<BawuRoleInfoPub> dxl = new ArrayList<>();
    private boolean dxm = false;
    private String dxn;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int axy() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> axz() {
        return this.dxl;
    }

    public void M(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dxl = arrayList;
    }

    public boolean isLast() {
        return this.dxm;
    }

    public void gj(boolean z) {
        this.dxm = z;
    }

    public String axA() {
        return this.dxn;
    }

    public void nn(String str) {
        this.dxn = str;
    }
}
