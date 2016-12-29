package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class q extends b implements s {
    public static final BdUniqueId beO = BdUniqueId.gen();
    public boolean beP = true;
    public boolean beQ = true;
    public String beR;
    public List<p> beS;
    public int beT;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return beO;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean OO() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cA(boolean z) {
        this.beP = z;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cB(boolean z) {
        this.beQ = z;
    }
}
