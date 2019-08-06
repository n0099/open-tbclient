package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId frI = BdUniqueId.gen();
    private String frC;
    private int frA = -1;
    private int frJ = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return frI;
    }

    public int bkL() {
        return this.frJ;
    }

    public void rj(int i) {
        this.frJ = i;
    }

    public int bkJ() {
        return this.frA;
    }

    public void ri(int i) {
        this.frA = i;
    }

    public String bkK() {
        return this.frC;
    }

    public void wO(String str) {
        this.frC = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.frC) || this.frA < 0;
    }
}
