package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class r extends b implements s {
    public static final BdUniqueId bfV = BdUniqueId.gen();
    public long bfW;
    public String bfX;
    public String bfY;
    public String bfZ;
    public String bga;
    public String bgb;
    public long bgc;
    public String bgd;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bfV;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return (int) this.bgc;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean Ps() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cy(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.s
    public void cz(boolean z) {
    }
}
