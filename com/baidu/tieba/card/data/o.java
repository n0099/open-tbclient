package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class o extends b implements p {
    public static final BdUniqueId emp = BdUniqueId.gen();
    public long emq;
    public String emr;
    public String ems;
    public String emt;
    public String emu;
    public String emv;
    public long emw;
    public String emx;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return emp;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.emw;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aQV() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void hT(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void hU(boolean z) {
    }
}
