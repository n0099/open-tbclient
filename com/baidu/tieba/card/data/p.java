package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bNz = BdUniqueId.gen();
    public boolean bNA = true;
    public boolean bNB = true;
    public String bNC;
    public List<o> bND;
    public int bcM;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bNz;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Yg() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dJ(boolean z) {
        this.bNA = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dK(boolean z) {
        this.bNB = z;
    }
}
