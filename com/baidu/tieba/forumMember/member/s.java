package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eWf = BdUniqueId.gen();
    private String eVV;
    private int eVT = -1;
    private int eWg = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWf;
    }

    public int bbj() {
        return this.eWg;
    }

    public void pJ(int i) {
        this.eWg = i;
    }

    public int bbg() {
        return this.eVT;
    }

    public void pI(int i) {
        this.eVT = i;
    }

    public String bbi() {
        return this.eVV;
    }

    public void uP(String str) {
        this.eVV = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.eVV) || this.eVT < 0;
    }
}
