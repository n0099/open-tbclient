package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class o extends BaseCardInfo implements p {
    public static final BdUniqueId iod = BdUniqueId.gen();
    public long ioe;
    public String iof;
    public String iog;
    public String ioh;
    public String ioi;
    public String ioj;
    public long iok;
    public String iol;
    public String userName;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iod;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.iok;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csC() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pa(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pb(boolean z) {
    }
}
