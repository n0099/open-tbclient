package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class r extends b implements t {
    public static final BdUniqueId bxO = BdUniqueId.gen();
    public boolean bxP = true;
    public boolean bxQ = true;
    public String bxR;
    public List<q> bxS;
    public int bxT;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bxO;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean Uc() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.t
    public void db(boolean z) {
        this.bxP = z;
    }

    @Override // com.baidu.tieba.card.data.t
    public void dc(boolean z) {
        this.bxQ = z;
    }
}
