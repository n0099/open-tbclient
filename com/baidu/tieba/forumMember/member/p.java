package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eVQ = BdUniqueId.gen();
    private String eVT;
    private String eVU;
    private int eVR = -1;
    private int eVS = -1;
    private int eVV = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVQ;
    }

    public int bbe() {
        return this.eVR;
    }

    public void pG(int i) {
        this.eVR = i;
    }

    public int bbf() {
        return this.eVV;
    }

    public void pH(int i) {
        this.eVV = i;
    }

    public int bbg() {
        return this.eVS;
    }

    public void pI(int i) {
        this.eVS = i;
    }

    public String bbh() {
        return this.eVT;
    }

    public void uO(String str) {
        this.eVT = str;
    }

    public String bbi() {
        return this.eVU;
    }

    public void uP(String str) {
        this.eVU = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.eVT) || StringUtils.isNull(this.eVU) || this.eVR < 0 || this.eVS < 0;
    }
}
