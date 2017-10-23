package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bNJ = BdUniqueId.gen();
    public boolean bNK = true;
    public boolean bNL = true;
    public String bNM;
    public List<o> bNN;
    public int beh;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bNJ;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean XV() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dC(boolean z) {
        this.bNK = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dD(boolean z) {
        this.bNL = z;
    }
}
