package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s extends b implements t {
    public static final BdUniqueId bvR = BdUniqueId.gen();
    public long bvS;
    public String bvT;
    public String bvU;
    public String bvV;
    public String bvW;
    public String bvX;
    public long bvY;
    public String bvZ;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bvR;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return (int) this.bvY;
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean Ta() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cR(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.t
    public void cS(boolean z) {
    }
}
