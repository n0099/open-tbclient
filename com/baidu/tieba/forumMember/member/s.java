package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fsI = BdUniqueId.gen();
    private String fsC;
    private int fsA = -1;
    private int fsJ = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fsI;
    }

    public int biC() {
        return this.fsJ;
    }

    public void qf(int i) {
        this.fsJ = i;
    }

    public int biA() {
        return this.fsA;
    }

    public void qe(int i) {
        this.fsA = i;
    }

    public String biB() {
        return this.fsC;
    }

    public void vF(String str) {
        this.fsC = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.fsC) || this.fsA < 0;
    }
}
