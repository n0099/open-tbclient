package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bJX = BdUniqueId.gen();
    public boolean bJY = true;
    public boolean bJZ = true;
    public String bKa;
    public List<o> bKb;
    public int bcO;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bJX;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean WK() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dF(boolean z) {
        this.bJY = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
        this.bJZ = z;
    }
}
