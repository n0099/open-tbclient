package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bOr = BdUniqueId.gen();
    public long bOs;
    public String bOt;
    public String bOu;
    public String bOv;
    public String bOw;
    public String bOx;
    public long bOy;
    public String bOz;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bOr;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bOy;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean XZ() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dD(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dE(boolean z) {
    }
}
