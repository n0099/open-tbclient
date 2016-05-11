package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
    public static final BdUniqueId aSr = BdUniqueId.gen();
    public boolean aRD;
    public long aSs;
    public String aSt;
    public String aSu;
    public String aSv;
    public String aSw;
    public String aSx;
    public long aSy;
    public String aSz;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aSr;
    }

    @Override // com.baidu.tieba.card.a.r
    public int getPosition() {
        return (int) this.aSy;
    }

    @Override // com.baidu.tieba.card.a.r
    public boolean Kn() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.r
    public void cj(boolean z) {
        this.aRD = z;
    }
}
