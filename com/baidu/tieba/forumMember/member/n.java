package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes7.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jff = BdUniqueId.gen();
    private String jeY;
    private int jeW = -1;
    private int jfg = -1;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jff;
    }

    public int cBd() {
        return this.jfg;
    }

    public void yp(int i) {
        this.jfg = i;
    }

    public int cBb() {
        return this.jeW;
    }

    public void yo(int i) {
        this.jeW = i;
    }

    public String cBc() {
        return this.jeY;
    }

    public void Ki(String str) {
        this.jeY = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.jeY) || this.jeW < 0;
    }
}
