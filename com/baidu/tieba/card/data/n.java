package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class n extends b implements p {
    public static final BdUniqueId cQD = BdUniqueId.gen();
    public int bIr;
    public boolean cQE = true;
    public boolean cQF = true;
    public String cQG;
    public List<m> cQH;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cQD;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aoG() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fk(boolean z) {
        this.cQE = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fl(boolean z) {
        this.cQF = z;
    }
}
