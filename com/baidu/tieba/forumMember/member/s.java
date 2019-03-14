package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eWs = BdUniqueId.gen();
    private String eWi;
    private int eWg = -1;
    private int eWt = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWs;
    }

    public int bbl() {
        return this.eWt;
    }

    public void pN(int i) {
        this.eWt = i;
    }

    public int bbi() {
        return this.eWg;
    }

    public void pM(int i) {
        this.eWg = i;
    }

    public String bbk() {
        return this.eWi;
    }

    public void uQ(String str) {
        this.eWi = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.eWi) || this.eWg < 0;
    }
}
