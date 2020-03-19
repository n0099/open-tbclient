package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gml = BdUniqueId.gen();
    private String gmo;
    private String gmp;
    private int gmm = -1;
    private int gmn = -1;
    private int gmq = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gml;
    }

    public void su(int i) {
        this.gmm = i;
    }

    public void sv(int i) {
        this.gmq = i;
    }

    public int bCG() {
        return this.gmn;
    }

    public void sw(int i) {
        this.gmn = i;
    }

    public void AZ(String str) {
        this.gmo = str;
    }

    public String bCH() {
        return this.gmp;
    }

    public void Ba(String str) {
        this.gmp = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.gmo) || StringUtils.isNull(this.gmp) || this.gmm < 0 || this.gmn < 0;
    }
}
