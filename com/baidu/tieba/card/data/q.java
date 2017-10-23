package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bOf = BdUniqueId.gen();
    public long bOg;
    public String bOh;
    public String bOi;
    public String bOj;
    public String bOk;
    public String bOl;
    public long bOm;
    public String bOn;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bOf;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bOm;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean XV() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dC(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dD(boolean z) {
    }
}
