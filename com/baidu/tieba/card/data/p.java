package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId bVn = BdUniqueId.gen();
    public boolean bVo = true;
    public boolean bVp = true;
    public String bVq;
    public List<o> bVr;
    public int beY;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return bVn;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aaf() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dB(boolean z) {
        this.bVo = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dC(boolean z) {
        this.bVp = z;
    }
}
