package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class o extends b implements q {
    public static final BdUniqueId dar = BdUniqueId.gen();
    public int bZq;
    public boolean das = true;
    public boolean dau = true;
    public String dav;
    public List<n> daw;
    public int position;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dar;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean alG() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eQ(boolean z) {
        this.das = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eR(boolean z) {
        this.dau = z;
    }
}
