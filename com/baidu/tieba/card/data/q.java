package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bVK = BdUniqueId.gen();
    public long bVL;
    public String bVM;
    public String bVN;
    public String bVO;
    public String bVP;
    public String bVQ;
    public long bVR;
    public String bVS;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bVK;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bVR;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aaf() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dB(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dC(boolean z) {
    }
}
