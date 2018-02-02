package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId cXN = BdUniqueId.gen();
    public int bXq;
    public boolean cXO = true;
    public boolean cXP = true;
    public String cXQ;
    public List<o> cXR;
    public int position;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return cXN;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean akX() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eK(boolean z) {
        this.cXO = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eL(boolean z) {
        this.cXP = z;
    }
}
