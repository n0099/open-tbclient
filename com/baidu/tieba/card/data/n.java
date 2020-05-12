package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends b implements p {
    public static final BdUniqueId gte = BdUniqueId.gen();
    public boolean gtf = true;
    public boolean gtg = true;
    public String gth;
    public List<m> gti;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gte;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bFm() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lA(boolean z) {
        this.gtf = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lB(boolean z) {
        this.gtg = z;
    }
}
