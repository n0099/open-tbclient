package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends b implements p {
    public static final BdUniqueId eIf = BdUniqueId.gen();
    public boolean eIg = true;
    public boolean eIh = true;
    public String eIi;
    public List<m> eIj;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eIf;
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
    public void iK(boolean z) {
        this.eIg = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iL(boolean z) {
        this.eIh = z;
    }
}
