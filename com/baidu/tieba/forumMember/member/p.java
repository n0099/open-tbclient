package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class p implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hku = BdUniqueId.gen();
    private String hkx;
    private String hky;
    private int hkv = -1;
    private int hkw = -1;
    private int hkz = -1;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hku;
    }

    public void ty(int i) {
        this.hkv = i;
    }

    public void tz(int i) {
        this.hkz = i;
    }

    public int bTC() {
        return this.hkw;
    }

    public void tA(int i) {
        this.hkw = i;
    }

    public void Ev(String str) {
        this.hkx = str;
    }

    public String bTD() {
        return this.hky;
    }

    public void Ew(String str) {
        this.hky = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hkx) || StringUtils.isNull(this.hky) || this.hkv < 0 || this.hkw < 0;
    }
}
