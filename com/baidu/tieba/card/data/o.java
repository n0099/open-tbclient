package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class o extends b implements q {
    public static final BdUniqueId daC = BdUniqueId.gen();
    public int bZz;
    public boolean daD = true;
    public boolean daE = true;
    public String daF;
    public List<n> daG;
    public int position;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return daC;
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
        this.daD = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eR(boolean z) {
        this.daE = z;
    }
}
