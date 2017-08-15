package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bKG = BdUniqueId.gen();
    public boolean bKH = true;
    public boolean bKI = true;
    public String bKJ;
    public List<o> bKK;
    public int bcP;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bKG;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Xg() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
        this.bKH = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dH(boolean z) {
        this.bKI = z;
    }
}
