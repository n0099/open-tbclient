package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fmj = BdUniqueId.gen();
    private String fmd;
    private int fmb = -1;
    private int fmk = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fmj;
    }

    public int biz() {
        return this.fmk;
    }

    public void qP(int i) {
        this.fmk = i;
    }

    public int bix() {
        return this.fmb;
    }

    public void qO(int i) {
        this.fmb = i;
    }

    public String biy() {
        return this.fmd;
    }

    public void wj(String str) {
        this.fmd = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.fmd) || this.fmb < 0;
    }
}
