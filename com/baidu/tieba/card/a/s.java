package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s extends b implements t {
    public static final BdUniqueId aQI = BdUniqueId.gen();
    public boolean aQE;
    public long aQJ;
    public String aQK;
    public String aQL;
    public String aQM;
    public String aQN;
    public String aQO;
    public long aQP;
    public String aQQ;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aQI;
    }

    @Override // com.baidu.tieba.card.a.t
    public int getPosition() {
        return (int) this.aQP;
    }

    @Override // com.baidu.tieba.card.a.t
    public boolean IM() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.t
    public void bO(boolean z) {
        this.aQE = z;
    }
}
