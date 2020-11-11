package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class p extends b implements q {
    public static final BdUniqueId icq = BdUniqueId.gen();
    public long icr;
    public String ics;
    public String ict;
    public String icu;
    public String icv;
    public String icw;
    public long icx;
    public String icy;
    public String userName;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return icq;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return (int) this.icx;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean coK() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void oB(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void oC(boolean z) {
    }
}
