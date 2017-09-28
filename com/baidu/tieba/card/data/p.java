package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bNV = BdUniqueId.gen();
    public boolean bNW = true;
    public boolean bNX = true;
    public String bNY;
    public List<o> bNZ;
    public int bew;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bNV;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean XZ() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dD(boolean z) {
        this.bNW = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dE(boolean z) {
        this.bNX = z;
    }
}
