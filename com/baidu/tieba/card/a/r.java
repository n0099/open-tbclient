package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class r extends b implements t {
    public static final BdUniqueId aQD = BdUniqueId.gen();
    public boolean aQE = true;
    public String aQF;
    public List<q> aQG;
    public int aQH;
    public int position;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aQD;
    }

    @Override // com.baidu.tieba.card.a.t
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.a.t
    public boolean IM() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.t
    public void bO(boolean z) {
        this.aQE = z;
    }
}
