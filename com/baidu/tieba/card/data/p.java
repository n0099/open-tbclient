package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId cem = BdUniqueId.gen();
    public int bjQ;
    public boolean cen = true;
    public boolean ceo = true;
    public String cep;
    public List<o> ceq;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cem;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean acj() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
        this.cen = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dX(boolean z) {
        this.ceo = z;
    }
}
