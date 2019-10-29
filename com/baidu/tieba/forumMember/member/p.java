package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fsy = BdUniqueId.gen();
    private String fsB;
    private String fsC;
    private int fsz = -1;
    private int fsA = -1;
    private int fsD = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fsy;
    }

    public void qc(int i) {
        this.fsz = i;
    }

    public void qd(int i) {
        this.fsD = i;
    }

    public int biA() {
        return this.fsA;
    }

    public void qe(int i) {
        this.fsA = i;
    }

    public void vE(String str) {
        this.fsB = str;
    }

    public String biB() {
        return this.fsC;
    }

    public void vF(String str) {
        this.fsC = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.fsB) || StringUtils.isNull(this.fsC) || this.fsz < 0 || this.fsA < 0;
    }
}
