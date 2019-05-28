package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fmk = BdUniqueId.gen();
    private String fme;
    private int fmc = -1;
    private int fml = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fmk;
    }

    public int biC() {
        return this.fml;
    }

    public void qP(int i) {
        this.fml = i;
    }

    public int biA() {
        return this.fmc;
    }

    public void qO(int i) {
        this.fmc = i;
    }

    public String biB() {
        return this.fme;
    }

    public void wj(String str) {
        this.fme = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.fme) || this.fmc < 0;
    }
}
