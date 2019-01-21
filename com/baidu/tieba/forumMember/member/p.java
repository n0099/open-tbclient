package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dIT = BdUniqueId.gen();
    private String dIW;
    private String dIX;
    private int dIU = -1;
    private int dIV = -1;
    private int dIY = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dIT;
    }

    public int aAH() {
        return this.dIU;
    }

    public void ma(int i) {
        this.dIU = i;
    }

    public int aAI() {
        return this.dIY;
    }

    public void mb(int i) {
        this.dIY = i;
    }

    public int aAJ() {
        return this.dIV;
    }

    public void mc(int i) {
        this.dIV = i;
    }

    public String aAK() {
        return this.dIW;
    }

    public void ol(String str) {
        this.dIW = str;
    }

    public String aAL() {
        return this.dIX;
    }

    public void om(String str) {
        this.dIX = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dIW) || StringUtils.isNull(this.dIX) || this.dIU < 0 || this.dIV < 0;
    }
}
