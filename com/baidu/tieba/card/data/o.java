package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class o extends b implements q {
    public static final BdUniqueId hVV = BdUniqueId.gen();
    public boolean hVW = true;
    public boolean hVX = true;
    public String hVY;
    public List<n> hVZ;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hVV;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cmj() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void os(boolean z) {
        this.hVW = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void ot(boolean z) {
        this.hVX = z;
    }
}
