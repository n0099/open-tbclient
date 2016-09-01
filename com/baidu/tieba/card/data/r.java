package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class r extends b implements s {
    public static final BdUniqueId bcC = BdUniqueId.gen();
    public boolean bbz;
    public long bcD;
    public String bcE;
    public String bcF;
    public String bcG;
    public String bcH;
    public String bcI;
    public long bcJ;
    public String bcK;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bcC;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return (int) this.bcJ;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean NO() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.s
    public void ct(boolean z) {
        this.bbz = z;
    }
}
