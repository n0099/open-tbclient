package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId aSn = BdUniqueId.gen();
    public boolean aRD = true;
    public String aSo;
    public List<o> aSp;
    public int aSq;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aSn;
    }

    @Override // com.baidu.tieba.card.a.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.a.r
    public boolean Kn() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.r
    public void cj(boolean z) {
        this.aRD = z;
    }
}
