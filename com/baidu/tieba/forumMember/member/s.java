package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId frR = BdUniqueId.gen();
    private String frL;
    private int frJ = -1;
    private int frS = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return frR;
    }

    public int biA() {
        return this.frS;
    }

    public void qe(int i) {
        this.frS = i;
    }

    public int biy() {
        return this.frJ;
    }

    public void qd(int i) {
        this.frJ = i;
    }

    public String biz() {
        return this.frL;
    }

    public void vF(String str) {
        this.frL = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.frL) || this.frJ < 0;
    }
}
