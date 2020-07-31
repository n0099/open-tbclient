package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes17.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hCz = BdUniqueId.gen();
    private String hCs;
    private int hCq = -1;
    private int hCA = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hCz;
    }

    public int bZU() {
        return this.hCA;
    }

    public void uu(int i) {
        this.hCA = i;
    }

    public int bZS() {
        return this.hCq;
    }

    public void ut(int i) {
        this.hCq = i;
    }

    public String bZT() {
        return this.hCs;
    }

    public void FI(String str) {
        this.hCs = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hCs) || this.hCq < 0;
    }
}
