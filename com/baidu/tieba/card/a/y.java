package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class y extends b implements z {
    public static final BdUniqueId aWx = BdUniqueId.gen();
    public boolean aVy;
    public String aWA;
    public String aWB;
    public String aWC;
    public String aWD;
    public long aWE;
    public String aWF;
    public long aWy;
    public String aWz;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aWx;
    }

    @Override // com.baidu.tieba.card.a.z
    public int getPosition() {
        return (int) this.aWE;
    }

    @Override // com.baidu.tieba.card.a.z
    public boolean LE() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.z
    public void cd(boolean z) {
        this.aVy = z;
    }
}
