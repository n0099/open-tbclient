package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iPL = BdUniqueId.gen();
    private String iPO;
    private String iPP;
    private int iPM = -1;
    private int iPN = -1;
    private int iPQ = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iPL;
    }

    public void zu(int i) {
        this.iPM = i;
    }

    public void zv(int i) {
        this.iPQ = i;
    }

    public int cAB() {
        return this.iPN;
    }

    public void zw(int i) {
        this.iPN = i;
    }

    public void KA(String str) {
        this.iPO = str;
    }

    public String cAC() {
        return this.iPP;
    }

    public void KB(String str) {
        this.iPP = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iPO) || StringUtils.isNull(this.iPP) || this.iPM < 0 || this.iPN < 0;
    }
}
