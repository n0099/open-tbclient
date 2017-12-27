package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId cSQ = BdUniqueId.gen();
    public int bXb;
    public boolean cSR = true;
    public boolean cSS = true;
    public String cST;
    public List<o> cSU;
    public int position;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return cSQ;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean ajP() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eD(boolean z) {
        this.cSR = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eE(boolean z) {
        this.cSS = z;
    }
}
