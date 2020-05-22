package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class o extends b implements p {
    public static final BdUniqueId gIn = BdUniqueId.gen();
    public long gIo;
    public String gIp;
    public String gIq;
    public String gIr;
    public String gIs;
    public String gIt;
    public long gIu;
    public String gIv;
    public String userName;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gIn;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.gIu;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bLG() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lW(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void lX(boolean z) {
    }
}
