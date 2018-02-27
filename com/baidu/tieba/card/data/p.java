package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends b implements q {
    public static final BdUniqueId daO = BdUniqueId.gen();
    public long daP;
    public String daQ;
    public String daR;
    public String daS;
    public String daT;
    public String daU;
    public long daV;
    public String daW;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return daO;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return (int) this.daV;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean alF() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eQ(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void eR(boolean z) {
    }
}
