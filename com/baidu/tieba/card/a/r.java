package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class r extends b implements s {
    public static final BdUniqueId aVM = BdUniqueId.gen();
    public boolean aUZ;
    public long aVN;
    public String aVO;
    public String aVP;
    public String aVQ;
    public String aVR;
    public String aVS;
    public long aVT;
    public String aVU;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aVM;
    }

    @Override // com.baidu.tieba.card.a.s
    public int getPosition() {
        return (int) this.aVT;
    }

    @Override // com.baidu.tieba.card.a.s
    public boolean Lm() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.s
    public void ck(boolean z) {
        this.aUZ = z;
    }
}
