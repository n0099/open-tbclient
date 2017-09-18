package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bOq = BdUniqueId.gen();
    public boolean bOr = true;
    public boolean bOs = true;
    public String bOt;
    public List<o> bOu;
    public int bcJ;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bOq;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Yr() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dK(boolean z) {
        this.bOr = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dL(boolean z) {
        this.bOs = z;
    }
}
