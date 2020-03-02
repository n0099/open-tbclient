package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId glq = BdUniqueId.gen();
    private String glt;
    private String glu;
    private int glr = -1;
    private int gls = -1;
    private int glv = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return glq;
    }

    public void ss(int i) {
        this.glr = i;
    }

    public void st(int i) {
        this.glv = i;
    }

    public int bCz() {
        return this.gls;
    }

    public void su(int i) {
        this.gls = i;
    }

    public void AW(String str) {
        this.glt = str;
    }

    public String bCA() {
        return this.glu;
    }

    public void AX(String str) {
        this.glu = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.glt) || StringUtils.isNull(this.glu) || this.glr < 0 || this.gls < 0;
    }
}
