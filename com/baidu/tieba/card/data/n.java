package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId inE = BdUniqueId.gen();
    public boolean inF = true;
    public boolean inG = true;
    public String inH;
    public List<m> inI;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return inE;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csC() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pa(boolean z) {
        this.inF = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pb(boolean z) {
        this.inG = z;
    }
}
