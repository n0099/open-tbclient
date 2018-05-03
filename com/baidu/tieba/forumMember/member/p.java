package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cUL = BdUniqueId.gen();
    private String cUO;
    private String cUP;
    private int cUM = -1;
    private int cUN = -1;
    private int cUQ = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUL;
    }

    public int aol() {
        return this.cUM;
    }

    public void jS(int i) {
        this.cUM = i;
    }

    public int aom() {
        return this.cUQ;
    }

    public void jT(int i) {
        this.cUQ = i;
    }

    public int aon() {
        return this.cUN;
    }

    public void jU(int i) {
        this.cUN = i;
    }

    public String aoo() {
        return this.cUO;
    }

    public void lC(String str) {
        this.cUO = str;
    }

    public String aop() {
        return this.cUP;
    }

    public void lD(String str) {
        this.cUP = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.cUO) || StringUtils.isNull(this.cUP) || this.cUM < 0 || this.cUN < 0;
    }
}
