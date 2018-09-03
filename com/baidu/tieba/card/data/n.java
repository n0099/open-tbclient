package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends b implements p {
    public static final BdUniqueId cCt = BdUniqueId.gen();
    public int btT;
    public boolean cCu = true;
    public boolean cCv = true;
    public String cCw;
    public List<m> cCx;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cCt;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ajs() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
        this.cCu = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eC(boolean z) {
        this.cCv = z;
    }
}
