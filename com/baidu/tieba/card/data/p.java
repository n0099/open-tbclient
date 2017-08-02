package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bIN = BdUniqueId.gen();
    public boolean bIO = true;
    public boolean bIP = true;
    public String bIQ;
    public List<o> bIR;
    public int bbE;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bIN;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean WF() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dF(boolean z) {
        this.bIO = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
        this.bIP = z;
    }
}
