package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId cdU = BdUniqueId.gen();
    public int bjL;
    public boolean cdV = true;
    public boolean cdW = true;
    public String cdX;
    public List<o> cdY;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cdU;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aca() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dV(boolean z) {
        this.cdV = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
        this.cdW = z;
    }
}
