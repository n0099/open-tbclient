package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes22.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iER = BdUniqueId.gen();
    private String iEU;
    private String iEV;
    private int iES = -1;
    private int iET = -1;
    private int iEW = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iER;
    }

    public void yP(int i) {
        this.iES = i;
    }

    public void yQ(int i) {
        this.iEW = i;
    }

    public int cwl() {
        return this.iET;
    }

    public void yR(int i) {
        this.iET = i;
    }

    public void JK(String str) {
        this.iEU = str;
    }

    public String cwm() {
        return this.iEV;
    }

    public void JL(String str) {
        this.iEV = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iEU) || StringUtils.isNull(this.iEV) || this.iES < 0 || this.iET < 0;
    }
}
