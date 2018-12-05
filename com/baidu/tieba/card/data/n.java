package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class n extends b implements p {
    public static final BdUniqueId cYq = BdUniqueId.gen();
    public int bMR;
    public boolean cYr = true;
    public boolean cYs = true;
    public String cYt;
    public List<m> cYu;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cYq;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean apU() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fw(boolean z) {
        this.cYr = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fx(boolean z) {
        this.cYs = z;
    }
}
