package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends b implements p {
    public static final BdUniqueId elW = BdUniqueId.gen();
    public boolean elX = true;
    public boolean elY = true;
    public String elZ;
    public List<m> ema;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return elW;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aQW() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hT(boolean z) {
        this.elX = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hU(boolean z) {
        this.elY = z;
    }
}
