package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eWe = BdUniqueId.gen();
    private String eWh;
    private String eWi;
    private int eWf = -1;
    private int eWg = -1;
    private int eWj = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWe;
    }

    public int bbg() {
        return this.eWf;
    }

    public void pK(int i) {
        this.eWf = i;
    }

    public int bbh() {
        return this.eWj;
    }

    public void pL(int i) {
        this.eWj = i;
    }

    public int bbi() {
        return this.eWg;
    }

    public void pM(int i) {
        this.eWg = i;
    }

    public String bbj() {
        return this.eWh;
    }

    public void uP(String str) {
        this.eWh = str;
    }

    public String bbk() {
        return this.eWi;
    }

    public void uQ(String str) {
        this.eWi = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.eWh) || StringUtils.isNull(this.eWi) || this.eWf < 0 || this.eWg < 0;
    }
}
