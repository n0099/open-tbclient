package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iPU = BdUniqueId.gen();
    private String iPN;
    private int iPL = -1;
    private int iPV = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iPU;
    }

    public int cAC() {
        return this.iPV;
    }

    public void zx(int i) {
        this.iPV = i;
    }

    public int cAA() {
        return this.iPL;
    }

    public void zw(int i) {
        this.iPL = i;
    }

    public String cAB() {
        return this.iPN;
    }

    public void KB(String str) {
        this.iPN = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iPN) || this.iPL < 0;
    }
}
