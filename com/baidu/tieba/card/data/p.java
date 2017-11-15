package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bVA = BdUniqueId.gen();
    public boolean bVB = true;
    public boolean bVC = true;
    public String bVD;
    public List<o> bVE;
    public int bfi;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bVA;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aar() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
        this.bVB = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dH(boolean z) {
        this.bVC = z;
    }
}
