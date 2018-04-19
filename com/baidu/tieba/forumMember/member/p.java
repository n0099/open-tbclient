package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cUO = BdUniqueId.gen();
    private String cUR;
    private String cUS;
    private int cUP = -1;
    private int cUQ = -1;
    private int cUT = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUO;
    }

    public int aol() {
        return this.cUP;
    }

    public void jS(int i) {
        this.cUP = i;
    }

    public int aom() {
        return this.cUT;
    }

    public void jT(int i) {
        this.cUT = i;
    }

    public int aon() {
        return this.cUQ;
    }

    public void jU(int i) {
        this.cUQ = i;
    }

    public String aoo() {
        return this.cUR;
    }

    public void lC(String str) {
        this.cUR = str;
    }

    public String aop() {
        return this.cUS;
    }

    public void lD(String str) {
        this.cUS = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.cUR) || StringUtils.isNull(this.cUS) || this.cUP < 0 || this.cUQ < 0;
    }
}
