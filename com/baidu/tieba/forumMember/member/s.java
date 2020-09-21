package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes22.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hWU = BdUniqueId.gen();
    private String hWN;
    private int hWL = -1;
    private int hWV = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hWU;
    }

    public int cnE() {
        return this.hWV;
    }

    public void xi(int i) {
        this.hWV = i;
    }

    public int cnC() {
        return this.hWL;
    }

    public void xh(int i) {
        this.hWL = i;
    }

    public String cnD() {
        return this.hWN;
    }

    public void IH(String str) {
        this.hWN = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hWN) || this.hWL < 0;
    }
}
