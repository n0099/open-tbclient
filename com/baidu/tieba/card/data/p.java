package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bxM = BdUniqueId.gen();
    public boolean bxN = true;
    public boolean bxO = true;
    public String bxP;
    public List<o> bxQ;
    public int bxR;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bxM;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Tv() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dd(boolean z) {
        this.bxN = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void de(boolean z) {
        this.bxO = z;
    }
}
