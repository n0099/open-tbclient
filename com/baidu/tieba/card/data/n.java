package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends b implements p {
    public static final BdUniqueId cCw = BdUniqueId.gen();
    public int btR;
    public List<m> cCA;
    public boolean cCx = true;
    public boolean cCy = true;
    public String cCz;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cCw;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ajp() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
        this.cCx = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eC(boolean z) {
        this.cCy = z;
    }
}
