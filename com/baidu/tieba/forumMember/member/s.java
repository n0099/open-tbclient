package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gly = BdUniqueId.gen();
    private String gls;
    private int glq = -1;
    private int glz = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gly;
    }

    public int bCz() {
        return this.glz;
    }

    public void sv(int i) {
        this.glz = i;
    }

    public int bCx() {
        return this.glq;
    }

    public void su(int i) {
        this.glq = i;
    }

    public String bCy() {
        return this.gls;
    }

    public void AX(String str) {
        this.gls = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.gls) || this.glq < 0;
    }
}
