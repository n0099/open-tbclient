package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eVR = BdUniqueId.gen();
    private String eVU;
    private String eVV;
    private int eVS = -1;
    private int eVT = -1;
    private int eVW = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVR;
    }

    public int bbe() {
        return this.eVS;
    }

    public void pG(int i) {
        this.eVS = i;
    }

    public int bbf() {
        return this.eVW;
    }

    public void pH(int i) {
        this.eVW = i;
    }

    public int bbg() {
        return this.eVT;
    }

    public void pI(int i) {
        this.eVT = i;
    }

    public String bbh() {
        return this.eVU;
    }

    public void uO(String str) {
        this.eVU = str;
    }

    public String bbi() {
        return this.eVV;
    }

    public void uP(String str) {
        this.eVV = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.eVU) || StringUtils.isNull(this.eVV) || this.eVS < 0 || this.eVT < 0;
    }
}
