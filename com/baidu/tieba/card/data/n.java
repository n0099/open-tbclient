package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends b implements p {
    public static final BdUniqueId elE = BdUniqueId.gen();
    public boolean elF = true;
    public boolean elG = true;
    public String elH;
    public List<m> elI;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return elE;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aQT() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hT(boolean z) {
        this.elF = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hU(boolean z) {
        this.elG = z;
    }
}
