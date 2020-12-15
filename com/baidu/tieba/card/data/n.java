package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseCardInfo implements p {
    public static final BdUniqueId inG = BdUniqueId.gen();
    public boolean inH = true;
    public boolean inI = true;
    public String inJ;
    public List<m> inK;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return inG;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csD() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pa(boolean z) {
        this.inH = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pb(boolean z) {
        this.inI = z;
    }
}
