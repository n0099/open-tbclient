package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bEV = BdUniqueId.gen();
    public long bEW;
    public String bEX;
    public String bEY;
    public String bEZ;
    public String bFa;
    public String bFb;
    public long bFc;
    public String bFd;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bEV;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bFc;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean VX() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dw(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dx(boolean z) {
    }
}
