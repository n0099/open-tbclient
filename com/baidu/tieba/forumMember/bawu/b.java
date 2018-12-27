package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class b implements i {
    private String dGA;
    private ArrayList<BawuRoleInfoPub> dGy = new ArrayList<>();
    private boolean dGz = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int azX() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> azY() {
        return this.dGy;
    }

    public void M(ArrayList<BawuRoleInfoPub> arrayList) {
        this.dGy = arrayList;
    }

    public boolean isLast() {
        return this.dGz;
    }

    public void gm(boolean z) {
        this.dGz = z;
    }

    public String azZ() {
        return this.dGA;
    }

    public void nP(String str) {
        this.dGA = str;
    }
}
