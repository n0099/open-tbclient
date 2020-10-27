package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iyr = BdUniqueId.gen();
    private String iyk;
    private int iyi = -1;
    private int iys = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iyr;
    }

    public int cuj() {
        return this.iys;
    }

    public void yh(int i) {
        this.iys = i;
    }

    public int cuh() {
        return this.iyi;
    }

    public void yg(int i) {
        this.iyi = i;
    }

    public String cui() {
        return this.iyk;
    }

    public void JT(String str) {
        this.iyk = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iyk) || this.iyi < 0;
    }
}
