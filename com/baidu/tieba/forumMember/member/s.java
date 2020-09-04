package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes17.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hPU = BdUniqueId.gen();
    private String hPN;
    private int hPL = -1;
    private int hPV = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hPU;
    }

    public int ckr() {
        return this.hPV;
    }

    public void wJ(int i) {
        this.hPV = i;
    }

    public int ckp() {
        return this.hPL;
    }

    public void wI(int i) {
        this.hPL = i;
    }

    public String ckq() {
        return this.hPN;
    }

    public void Ik(String str) {
        this.hPN = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hPN) || this.hPL < 0;
    }
}
