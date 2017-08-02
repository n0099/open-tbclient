package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ckl = BdUniqueId.gen();
    private long ckm;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ckl;
    }

    public long afX() {
        return this.ckm;
    }

    public void bh(long j) {
        this.ckm = j;
    }
}
