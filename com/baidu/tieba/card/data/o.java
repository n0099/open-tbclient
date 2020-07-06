package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class o extends b implements p {
    public static final BdUniqueId gVy = BdUniqueId.gen();
    public String gVA;
    public String gVB;
    public String gVC;
    public String gVD;
    public String gVE;
    public long gVF;
    public String gVG;
    public long gVz;
    public String userName;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gVy;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.gVF;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bOT() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mf(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void mg(boolean z) {
    }
}
