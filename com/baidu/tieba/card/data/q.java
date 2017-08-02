package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bJh = BdUniqueId.gen();
    public long bJi;
    public String bJj;
    public String bJk;
    public String bJl;
    public String bJm;
    public String bJn;
    public long bJo;
    public String bJp;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bJh;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bJo;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean WF() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dF(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
    }
}
