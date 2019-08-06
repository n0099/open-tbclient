package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fry = BdUniqueId.gen();
    private String frB;
    private String frC;
    private int frz = -1;
    private int frA = -1;
    private int frD = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fry;
    }

    public void rg(int i) {
        this.frz = i;
    }

    public void rh(int i) {
        this.frD = i;
    }

    public int bkJ() {
        return this.frA;
    }

    public void ri(int i) {
        this.frA = i;
    }

    public void wN(String str) {
        this.frB = str;
    }

    public String bkK() {
        return this.frC;
    }

    public void wO(String str) {
        this.frC = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.frB) || StringUtils.isNull(this.frC) || this.frz < 0 || this.frA < 0;
    }
}
