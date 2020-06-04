package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class o extends b implements p {
    public static final BdUniqueId gIy = BdUniqueId.gen();
    public String gIA;
    public String gIB;
    public String gIC;
    public String gID;
    public String gIE;
    public long gIF;
    public String gIG;
    public long gIz;
    public String userName;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gIy;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return (int) this.gIF;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bLI() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lW(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void lX(boolean z) {
    }
}
