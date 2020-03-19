package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gmv = BdUniqueId.gen();
    private String gmp;
    private int gmn = -1;
    private int gmw = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gmv;
    }

    public int bCI() {
        return this.gmw;
    }

    public void sx(int i) {
        this.gmw = i;
    }

    public int bCG() {
        return this.gmn;
    }

    public void sw(int i) {
        this.gmn = i;
    }

    public String bCH() {
        return this.gmp;
    }

    public void Ba(String str) {
        this.gmp = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.gmp) || this.gmn < 0;
    }
}
