package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes7.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ggd = BdUniqueId.gen();
    private String ggg;
    private String ggh;
    private int gge = -1;
    private int ggf = -1;
    private int ggi = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ggd;
    }

    public void sh(int i) {
        this.gge = i;
    }

    public void si(int i) {
        this.ggi = i;
    }

    public int bzT() {
        return this.ggf;
    }

    public void sj(int i) {
        this.ggf = i;
    }

    public void Aw(String str) {
        this.ggg = str;
    }

    public String bzU() {
        return this.ggh;
    }

    public void Ax(String str) {
        this.ggh = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.ggg) || StringUtils.isNull(this.ggh) || this.gge < 0 || this.ggf < 0;
    }
}
