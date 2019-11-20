package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends b implements p {
    public static final BdUniqueId ePT = BdUniqueId.gen();
    public boolean ePU = true;
    public boolean ePV = true;
    public String ePW;
    public List<m> ePX;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ePT;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baK() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iN(boolean z) {
        this.ePU = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iO(boolean z) {
        this.ePV = z;
    }
}
