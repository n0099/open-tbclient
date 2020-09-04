package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class o extends b implements q {
    public static final BdUniqueId hnz = BdUniqueId.gen();
    public boolean hnA = true;
    public boolean hnB = true;
    public String hnC;
    public List<n> hnD;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hnz;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean ccr() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void np(boolean z) {
        this.hnA = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nq(boolean z) {
        this.hnB = z;
    }
}
