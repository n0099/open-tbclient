package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class r extends b implements s {
    public static final BdUniqueId bcW = BdUniqueId.gen();
    public long bcX;
    public String bcY;
    public String bcZ;
    public String bda;
    public String bdb;
    public String bdc;
    public long bdd;
    public String bde;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bcW;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return (int) this.bdd;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean Op() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.s
    public void ct(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.s
    public void cu(boolean z) {
    }
}
