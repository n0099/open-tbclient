package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId iBd = BdUniqueId.gen();
    public boolean iBe = true;
    public boolean iBf = true;
    public String iBg;
    public List<m> iBh;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iBd;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csR() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pE(boolean z) {
        this.iBe = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pF(boolean z) {
        this.iBf = z;
    }
}
