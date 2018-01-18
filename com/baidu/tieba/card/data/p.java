package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId cXs = BdUniqueId.gen();
    public int bXi;
    public boolean cXt = true;
    public boolean cXu = true;
    public String cXv;
    public List<o> cXw;
    public int position;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return cXs;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean akS() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eH(boolean z) {
        this.cXt = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eI(boolean z) {
        this.cXu = z;
    }
}
