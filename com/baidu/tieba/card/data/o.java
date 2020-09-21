package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class o extends b implements q {
    public static final BdUniqueId huD = BdUniqueId.gen();
    public boolean huE = true;
    public boolean huF = true;
    public String huG;
    public List<n> huH;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return huD;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cfG() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nv(boolean z) {
        this.huE = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nw(boolean z) {
        this.huF = z;
    }
}
