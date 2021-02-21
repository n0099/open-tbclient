package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId iBr = BdUniqueId.gen();
    public boolean iBs = true;
    public boolean iBt = true;
    public String iBu;
    public List<m> iBv;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iBr;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csY() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pE(boolean z) {
        this.iBs = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pF(boolean z) {
        this.iBt = z;
    }
}
