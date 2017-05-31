package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId bEd = BdUniqueId.gen();
    public long bEe;
    public String bEf;
    public String bEg;
    public String bEh;
    public String bEi;
    public String bEj;
    public long bEk;
    public String bEl;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bEd;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.bEk;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean UG() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void du(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dv(boolean z) {
    }
}
