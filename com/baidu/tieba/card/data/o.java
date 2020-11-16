package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes21.dex */
public class o extends BaseCardInfo implements p {
    public static final BdUniqueId idf = BdUniqueId.gen();
    public long idg;
    public String idh;
    public String idi;
    public String idj;
    public String idk;
    public String idm;
    public long idn;
    public String ido;
    public String userName;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return idf;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.idn;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cop() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void oE(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void oF(boolean z) {
    }
}
