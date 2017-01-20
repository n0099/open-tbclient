package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s extends b implements t {
    public static final BdUniqueId bpd = BdUniqueId.gen();
    public long bpe;
    public String bpf;
    public String bpg;
    public String bph;
    public String bpi;
    public String bpj;
    public long bpk;
    public String bpl;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bpd;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return (int) this.bpk;
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean RE() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cP(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.t
    public void cQ(boolean z) {
    }
}
