package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class s implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hkt = BdUniqueId.gen();
    private String hkn;
    private int hkl = -1;
    private int hku = -1;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hkt;
    }

    public int bTC() {
        return this.hku;
    }

    public void tz(int i) {
        this.hku = i;
    }

    public int bTA() {
        return this.hkl;
    }

    public void ty(int i) {
        this.hkl = i;
    }

    public String bTB() {
        return this.hkn;
    }

    public void Ew(String str) {
        this.hkn = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hkn) || this.hkl < 0;
    }
}
