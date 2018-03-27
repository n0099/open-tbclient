package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends b implements q {
    public static final BdUniqueId daR = BdUniqueId.gen();
    public long daS;
    public String daT;
    public String daU;
    public String daV;
    public String daW;
    public String daX;
    public long daY;
    public String daZ;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return daR;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return (int) this.daY;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean alG() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eQ(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void eR(boolean z) {
    }
}
