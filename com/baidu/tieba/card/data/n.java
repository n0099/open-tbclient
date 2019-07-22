package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends b implements p {
    public static final BdUniqueId eGp = BdUniqueId.gen();
    public boolean eGq = true;
    public boolean eGr = true;
    public String eGs;
    public List<m> eGt;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eGp;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bae() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iH(boolean z) {
        this.eGq = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iI(boolean z) {
        this.eGr = z;
    }
}
