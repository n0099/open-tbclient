package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends b implements p {
    public static final BdUniqueId csm = BdUniqueId.gen();
    public int bjq;
    public boolean csn = true;
    public boolean cso = true;
    public String csp;
    public List<m> csq;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return csm;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean afO() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ev(boolean z) {
        this.csn = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ew(boolean z) {
        this.cso = z;
    }
}
