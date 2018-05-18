package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends b implements p {
    public static final BdUniqueId cts = BdUniqueId.gen();
    public int bjG;
    public boolean ctt = true;
    public boolean ctu = true;
    public String ctv;
    public List<m> ctw;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cts;
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
    public void ew(boolean z) {
        this.ctt = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ex(boolean z) {
        this.ctu = z;
    }
}
