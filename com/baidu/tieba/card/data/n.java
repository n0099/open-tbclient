package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends b implements p {
    public static final BdUniqueId haE = BdUniqueId.gen();
    public boolean haF = true;
    public boolean haG = true;
    public String haH;
    public List<m> haI;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return haE;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bSe() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mK(boolean z) {
        this.haF = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mL(boolean z) {
        this.haG = z;
    }
}
