package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes17.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hPO = BdUniqueId.gen();
    private String hPH;
    private int hPF = -1;
    private int hPP = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hPO;
    }

    public int ckq() {
        return this.hPP;
    }

    public void wJ(int i) {
        this.hPP = i;
    }

    public int cko() {
        return this.hPF;
    }

    public void wI(int i) {
        this.hPF = i;
    }

    public String ckp() {
        return this.hPH;
    }

    public void Ij(String str) {
        this.hPH = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hPH) || this.hPF < 0;
    }
}
