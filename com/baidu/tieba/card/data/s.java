package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s extends b implements t {
    public static final BdUniqueId bvY = BdUniqueId.gen();
    public long bvZ;
    public String bwa;
    public String bwb;
    public String bwc;
    public String bwd;
    public String bwe;
    public long bwf;
    public String bwg;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bvY;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return (int) this.bwf;
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean SC() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cP(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.t
    public void cQ(boolean z) {
    }
}
