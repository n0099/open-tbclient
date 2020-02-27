package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId glo = BdUniqueId.gen();
    private String glr;
    private String gls;
    private int glp = -1;
    private int glq = -1;
    private int glt = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return glo;
    }

    public void ss(int i) {
        this.glp = i;
    }

    public void st(int i) {
        this.glt = i;
    }

    public int bCx() {
        return this.glq;
    }

    public void su(int i) {
        this.glq = i;
    }

    public void AW(String str) {
        this.glr = str;
    }

    public String bCy() {
        return this.gls;
    }

    public void AX(String str) {
        this.gls = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.glr) || StringUtils.isNull(this.gls) || this.glp < 0 || this.glq < 0;
    }
}
