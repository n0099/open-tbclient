package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class r extends b implements t {
    public static final BdUniqueId bvE = BdUniqueId.gen();
    public boolean bvF = true;
    public boolean bvG = true;
    public String bvH;
    public List<q> bvI;
    public int bvJ;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bvE;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean SC() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cP(boolean z) {
        this.bvF = z;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cQ(boolean z) {
        this.bvG = z;
    }
}
