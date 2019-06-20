package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fma = BdUniqueId.gen();
    private String fmd;
    private String fme;
    private int fmb = -1;
    private int fmc = -1;
    private int fmf = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fma;
    }

    public void qM(int i) {
        this.fmb = i;
    }

    public void qN(int i) {
        this.fmf = i;
    }

    public int biA() {
        return this.fmc;
    }

    public void qO(int i) {
        this.fmc = i;
    }

    public void wh(String str) {
        this.fmd = str;
    }

    public String biB() {
        return this.fme;
    }

    public void wi(String str) {
        this.fme = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.fmd) || StringUtils.isNull(this.fme) || this.fmb < 0 || this.fmc < 0;
    }
}
