package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class r extends b implements t {
    public static final BdUniqueId bvx = BdUniqueId.gen();
    public String bvA;
    public List<q> bvB;
    public int bvC;
    public boolean bvy = true;
    public boolean bvz = true;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bvx;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean Ta() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cR(boolean z) {
        this.bvy = z;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cS(boolean z) {
        this.bvz = z;
    }
}
