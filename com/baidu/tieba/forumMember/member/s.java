package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId glA = BdUniqueId.gen();
    private String glu;
    private int gls = -1;
    private int glB = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return glA;
    }

    public int bCB() {
        return this.glB;
    }

    public void sv(int i) {
        this.glB = i;
    }

    public int bCz() {
        return this.gls;
    }

    public void su(int i) {
        this.gls = i;
    }

    public String bCA() {
        return this.glu;
    }

    public void AX(String str) {
        this.glu = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.glu) || this.gls < 0;
    }
}
