package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class p implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hkj = BdUniqueId.gen();
    private String hkm;
    private String hkn;
    private int hkk = -1;
    private int hkl = -1;
    private int hko = -1;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hkj;
    }

    public void tw(int i) {
        this.hkk = i;
    }

    public void tx(int i) {
        this.hko = i;
    }

    public int bTA() {
        return this.hkl;
    }

    public void ty(int i) {
        this.hkl = i;
    }

    public void Ev(String str) {
        this.hkm = str;
    }

    public String bTB() {
        return this.hkn;
    }

    public void Ew(String str) {
        this.hkn = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hkm) || StringUtils.isNull(this.hkn) || this.hkk < 0 || this.hkl < 0;
    }
}
