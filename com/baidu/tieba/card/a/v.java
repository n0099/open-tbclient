package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class v extends b implements w {
    public static final BdUniqueId aSL = BdUniqueId.gen();
    public boolean aRQ;
    public long aSM;
    public String aSN;
    public String aSO;
    public String aSP;
    public String aSQ;
    public String aSR;
    public long aSS;
    public String aST;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aSL;
    }

    @Override // com.baidu.tieba.card.a.w
    public int getPosition() {
        return (int) this.aSS;
    }

    @Override // com.baidu.tieba.card.a.w
    public boolean Kk() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.w
    public void bT(boolean z) {
        this.aRQ = z;
    }
}
