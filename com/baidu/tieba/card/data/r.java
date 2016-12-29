package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class r extends b implements s {
    public static final BdUniqueId bfk = BdUniqueId.gen();
    public long bfl;
    public String bfm;
    public String bfn;
    public String bfo;
    public String bfp;
    public String bfq;
    public long bfr;
    public String bfs;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bfk;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return (int) this.bfr;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean OO() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.s
    public void cB(boolean z) {
    }
}
