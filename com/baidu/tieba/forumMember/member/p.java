package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gVx = BdUniqueId.gen();
    private String gVA;
    private String gVB;
    private int gVy = -1;
    private int gVz = -1;
    private int gVC = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gVx;
    }

    public void sR(int i) {
        this.gVy = i;
    }

    public void sS(int i) {
        this.gVC = i;
    }

    public int bNe() {
        return this.gVz;
    }

    public void sT(int i) {
        this.gVz = i;
    }

    public void CM(String str) {
        this.gVA = str;
    }

    public String bNf() {
        return this.gVB;
    }

    public void CN(String str) {
        this.gVB = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.gVA) || StringUtils.isNull(this.gVB) || this.gVy < 0 || this.gVz < 0;
    }
}
