package com.baidu.tieba.forumMember.bawu;

import java.util.ArrayList;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes23.dex */
public class b implements i {
    private String iCx;
    private ArrayList<BawuRoleInfoPub> mMembers = new ArrayList<>();
    private boolean iCv = false;
    private boolean iCw = false;

    @Override // com.baidu.tieba.forumMember.bawu.i
    public int cww() {
        return 1;
    }

    public ArrayList<BawuRoleInfoPub> cwx() {
        return this.mMembers;
    }

    public void av(ArrayList<BawuRoleInfoPub> arrayList) {
        this.mMembers = arrayList;
    }

    public boolean isLast() {
        return this.iCv;
    }

    public void pi(boolean z) {
        this.iCv = z;
    }

    public boolean cwy() {
        return this.iCw;
    }

    public void pj(boolean z) {
        this.iCw = z;
    }

    public String cwz() {
        return this.iCx;
    }

    public void Kf(String str) {
        this.iCx = str;
    }
}
