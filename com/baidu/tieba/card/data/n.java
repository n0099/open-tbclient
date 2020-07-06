package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends b implements p {
    public static final BdUniqueId gVa = BdUniqueId.gen();
    public boolean gVb = true;
    public boolean gVc = true;
    public String gVd;
    public List<m> gVe;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gVa;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bOT() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mf(boolean z) {
        this.gVb = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mg(boolean z) {
        this.gVc = z;
    }
}
