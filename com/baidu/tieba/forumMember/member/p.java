package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hwB = BdUniqueId.gen();
    private String hwE;
    private String hwF;
    private int hwC = -1;
    private int hwD = -1;
    private int hwG = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hwB;
    }

    public void tZ(int i) {
        this.hwC = i;
    }

    public void ua(int i) {
        this.hwG = i;
    }

    public int bWz() {
        return this.hwD;
    }

    public void ub(int i) {
        this.hwD = i;
    }

    public void EW(String str) {
        this.hwE = str;
    }

    public String bWA() {
        return this.hwF;
    }

    public void EX(String str) {
        this.hwF = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hwE) || StringUtils.isNull(this.hwF) || this.hwC < 0 || this.hwD < 0;
    }
}
