package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId flZ = BdUniqueId.gen();
    private String fmc;
    private String fmd;
    private int fma = -1;
    private int fmb = -1;
    private int fme = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return flZ;
    }

    public void qM(int i) {
        this.fma = i;
    }

    public void qN(int i) {
        this.fme = i;
    }

    public int bix() {
        return this.fmb;
    }

    public void qO(int i) {
        this.fmb = i;
    }

    public void wi(String str) {
        this.fmc = str;
    }

    public String biy() {
        return this.fmd;
    }

    public void wj(String str) {
        this.fmd = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.fmc) || StringUtils.isNull(this.fmd) || this.fma < 0 || this.fmb < 0;
    }
}
