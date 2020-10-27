package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iyg = BdUniqueId.gen();
    private String iyj;
    private String iyk;
    private int iyh = -1;
    private int iyi = -1;
    private int iyl = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iyg;
    }

    public void ye(int i) {
        this.iyh = i;
    }

    public void yf(int i) {
        this.iyl = i;
    }

    public int cuh() {
        return this.iyi;
    }

    public void yg(int i) {
        this.iyi = i;
    }

    public void JS(String str) {
        this.iyj = str;
    }

    public String cui() {
        return this.iyk;
    }

    public void JT(String str) {
        this.iyk = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iyj) || StringUtils.isNull(this.iyk) || this.iyh < 0 || this.iyi < 0;
    }
}
