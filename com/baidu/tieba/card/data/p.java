package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bDI = BdUniqueId.gen();
    public boolean bDJ = true;
    public boolean bDK = true;
    public String bDL;
    public List<o> bDM;
    public int bDN;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bDI;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean UG() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void du(boolean z) {
        this.bDJ = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dv(boolean z) {
        this.bDK = z;
    }
}
