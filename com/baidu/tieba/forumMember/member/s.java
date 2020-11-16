package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes22.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iFc = BdUniqueId.gen();
    private String iEV;
    private int iET = -1;
    private int iFd = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iFc;
    }

    public int cwn() {
        return this.iFd;
    }

    public void yS(int i) {
        this.iFd = i;
    }

    public int cwl() {
        return this.iET;
    }

    public void yR(int i) {
        this.iET = i;
    }

    public String cwm() {
        return this.iEV;
    }

    public void JL(String str) {
        this.iEV = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iEV) || this.iET < 0;
    }
}
