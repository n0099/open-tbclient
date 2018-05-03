package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends b implements p {
    public static final BdUniqueId csj = BdUniqueId.gen();
    public int bjq;
    public boolean csk = true;
    public boolean csl = true;
    public String csm;
    public List<m> csn;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return csj;
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
        this.csk = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ew(boolean z) {
        this.csl = z;
    }
}
