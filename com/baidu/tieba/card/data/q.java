package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId cYn = BdUniqueId.gen();
    public long cYo;
    public String cYp;
    public String cYq;
    public String cYr;
    public String cYs;
    public String cYt;
    public long cYu;
    public String cYv;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return cYn;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.cYu;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean akX() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eK(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void eL(boolean z) {
    }
}
