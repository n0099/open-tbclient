package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bKH = BdUniqueId.gen();
    public boolean bKI = true;
    public boolean bKJ = true;
    public String bKK;
    public List<o> bKL;
    public int bcQ;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bKH;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Xd() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
        this.bKI = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dH(boolean z) {
        this.bKJ = z;
    }
}
