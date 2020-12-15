package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iPW = BdUniqueId.gen();
    private String iPP;
    private int iPN = -1;
    private int iPX = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iPW;
    }

    public int cAD() {
        return this.iPX;
    }

    public void zx(int i) {
        this.iPX = i;
    }

    public int cAB() {
        return this.iPN;
    }

    public void zw(int i) {
        this.iPN = i;
    }

    public String cAC() {
        return this.iPP;
    }

    public void KB(String str) {
        this.iPP = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iPP) || this.iPN < 0;
    }
}
