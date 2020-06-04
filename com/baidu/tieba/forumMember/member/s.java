package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class s implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hkE = BdUniqueId.gen();
    private String hky;
    private int hkw = -1;
    private int hkF = -1;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hkE;
    }

    public int bTE() {
        return this.hkF;
    }

    public void tB(int i) {
        this.hkF = i;
    }

    public int bTC() {
        return this.hkw;
    }

    public void tA(int i) {
        this.hkw = i;
    }

    public String bTD() {
        return this.hky;
    }

    public void Ew(String str) {
        this.hky = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hky) || this.hkw < 0;
    }
}
