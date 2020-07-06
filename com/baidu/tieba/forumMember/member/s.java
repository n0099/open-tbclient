package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hwL = BdUniqueId.gen();
    private String hwF;
    private int hwD = -1;
    private int hwM = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hwL;
    }

    public int bWB() {
        return this.hwM;
    }

    public void uc(int i) {
        this.hwM = i;
    }

    public int bWz() {
        return this.hwD;
    }

    public void ub(int i) {
        this.hwD = i;
    }

    public String bWA() {
        return this.hwF;
    }

    public void EX(String str) {
        this.hwF = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hwF) || this.hwD < 0;
    }
}
