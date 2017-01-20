package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class r extends b implements t {
    public static final BdUniqueId boJ = BdUniqueId.gen();
    public boolean boK = true;
    public boolean boL = true;
    public String boM;
    public List<q> boN;
    public int boO;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return boJ;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean RE() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cP(boolean z) {
        this.boK = z;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cQ(boolean z) {
        this.boL = z;
    }
}
