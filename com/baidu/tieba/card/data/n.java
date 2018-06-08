package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends b implements p {
    public static final BdUniqueId cBX = BdUniqueId.gen();
    public int brK;
    public boolean cBY = true;
    public boolean cBZ = true;
    public String cCa;
    public List<m> cCb;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cBX;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ajw() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eA(boolean z) {
        this.cBY = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
        this.cBZ = z;
    }
}
