package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes23.dex */
public class b implements i {
    private String iwA;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean iwy = false;
    private boolean iwz = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int ctV() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> ctW() {
        return this.mMembers;
    }

    public void av(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.iwy;
    }

    public void oZ(boolean z) {
        this.iwy = z;
    }

    public boolean ctX() {
        return this.iwz;
    }

    public void pa(boolean z) {
        this.iwz = z;
    }

    public String ctY() {
        return this.iwA;
    }

    public void JO(String str) {
        this.iwA = str;
    }
}
