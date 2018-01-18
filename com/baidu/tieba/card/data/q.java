package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId cXS = BdUniqueId.gen();
    public long cXT;
    public String cXU;
    public String cXV;
    public String cXW;
    public String cXX;
    public String cXY;
    public long cXZ;
    public String cYa;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return cXS;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.cXZ;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean akS() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eH(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void eI(boolean z) {
    }
}
