package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId glN = BdUniqueId.gen();
    private String glH;
    private int glF = -1;
    private int glO = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return glN;
    }

    public int bCC() {
        return this.glO;
    }

    public void sv(int i) {
        this.glO = i;
    }

    public int bCA() {
        return this.glF;
    }

    public void su(int i) {
        this.glF = i;
    }

    public String bCB() {
        return this.glH;
    }

    public void AY(String str) {
        this.glH = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.glH) || this.glF < 0;
    }
}
