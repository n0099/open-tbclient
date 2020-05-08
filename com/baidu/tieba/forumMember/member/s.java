package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gVH = BdUniqueId.gen();
    private String gVB;
    private int gVz = -1;
    private int gVI = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gVH;
    }

    public int bNg() {
        return this.gVI;
    }

    public void sU(int i) {
        this.gVI = i;
    }

    public int bNe() {
        return this.gVz;
    }

    public void sT(int i) {
        this.gVz = i;
    }

    public String bNf() {
        return this.gVB;
    }

    public void CN(String str) {
        this.gVB = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.gVB) || this.gVz < 0;
    }
}
