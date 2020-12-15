package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class o extends BaseCardInfo implements p {
    public static final BdUniqueId iof = BdUniqueId.gen();
    public long iog;
    public String ioh;
    public String ioi;
    public String ioj;
    public String iok;
    public String iol;
    public long iom;
    public String ion;
    public String userName;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iof;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.iom;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csD() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pa(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pb(boolean z) {
    }
}
