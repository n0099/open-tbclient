package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bEB = BdUniqueId.gen();
    public boolean bEC = true;
    public boolean bED = true;
    public String bEE;
    public List<o> bEF;
    public int bak;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bEB;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean VX() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dw(boolean z) {
        this.bEC = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dx(boolean z) {
        this.bED = z;
    }
}
