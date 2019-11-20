package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId frH = BdUniqueId.gen();
    private String frK;
    private String frL;
    private int frI = -1;
    private int frJ = -1;
    private int frM = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return frH;
    }

    public void qb(int i) {
        this.frI = i;
    }

    public void qc(int i) {
        this.frM = i;
    }

    public int biy() {
        return this.frJ;
    }

    public void qd(int i) {
        this.frJ = i;
    }

    public void vE(String str) {
        this.frK = str;
    }

    public String biz() {
        return this.frL;
    }

    public void vF(String str) {
        this.frL = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.frK) || StringUtils.isNull(this.frL) || this.frI < 0 || this.frJ < 0;
    }
}
