package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eWe = BdUniqueId.gen();
    private String eVU;
    private int eVS = -1;
    private int eWf = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWe;
    }

    public int bbj() {
        return this.eWf;
    }

    public void pJ(int i) {
        this.eWf = i;
    }

    public int bbg() {
        return this.eVS;
    }

    public void pI(int i) {
        this.eVS = i;
    }

    public String bbi() {
        return this.eVU;
    }

    public void uP(String str) {
        this.eVU = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.eVU) || this.eVS < 0;
    }
}
