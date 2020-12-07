package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iPJ = BdUniqueId.gen();
    private String iPM;
    private String iPN;
    private int iPK = -1;
    private int iPL = -1;
    private int iPO = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iPJ;
    }

    public void zu(int i) {
        this.iPK = i;
    }

    public void zv(int i) {
        this.iPO = i;
    }

    public int cAA() {
        return this.iPL;
    }

    public void zw(int i) {
        this.iPL = i;
    }

    public void KA(String str) {
        this.iPM = str;
    }

    public String cAB() {
        return this.iPN;
    }

    public void KB(String str) {
        this.iPN = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iPM) || StringUtils.isNull(this.iPN) || this.iPK < 0 || this.iPL < 0;
    }
}
