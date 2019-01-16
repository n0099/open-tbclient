package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dIS = BdUniqueId.gen();
    private String dIV;
    private String dIW;
    private int dIT = -1;
    private int dIU = -1;
    private int dIX = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dIS;
    }

    public int aAH() {
        return this.dIT;
    }

    public void ma(int i) {
        this.dIT = i;
    }

    public int aAI() {
        return this.dIX;
    }

    public void mb(int i) {
        this.dIX = i;
    }

    public int aAJ() {
        return this.dIU;
    }

    public void mc(int i) {
        this.dIU = i;
    }

    public String aAK() {
        return this.dIV;
    }

    public void ol(String str) {
        this.dIV = str;
    }

    public String aAL() {
        return this.dIW;
    }

    public void om(String str) {
        this.dIW = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dIV) || StringUtils.isNull(this.dIW) || this.dIT < 0 || this.dIU < 0;
    }
}
