package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes7.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ggn = BdUniqueId.gen();
    private String ggh;
    private int ggf = -1;
    private int ggo = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ggn;
    }

    public int bzV() {
        return this.ggo;
    }

    public void sk(int i) {
        this.ggo = i;
    }

    public int bzT() {
        return this.ggf;
    }

    public void sj(int i) {
        this.ggf = i;
    }

    public String bzU() {
        return this.ggh;
    }

    public void Ax(String str) {
        this.ggh = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.ggh) || this.ggf < 0;
    }
}
