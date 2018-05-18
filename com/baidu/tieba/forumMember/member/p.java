package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cVS = BdUniqueId.gen();
    private String cVV;
    private String cVW;
    private int cVT = -1;
    private int cVU = -1;
    private int cVX = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cVS;
    }

    public int aok() {
        return this.cVT;
    }

    public void jR(int i) {
        this.cVT = i;
    }

    public int aol() {
        return this.cVX;
    }

    public void jS(int i) {
        this.cVX = i;
    }

    public int aom() {
        return this.cVU;
    }

    public void jT(int i) {
        this.cVU = i;
    }

    public String aon() {
        return this.cVV;
    }

    public void lF(String str) {
        this.cVV = str;
    }

    public String aoo() {
        return this.cVW;
    }

    public void lG(String str) {
        this.cVW = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.cVV) || StringUtils.isNull(this.cVW) || this.cVT < 0 || this.cVU < 0;
    }
}
