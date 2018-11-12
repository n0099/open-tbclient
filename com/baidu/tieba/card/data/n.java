package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class n extends b implements p {
    public static final BdUniqueId cRJ = BdUniqueId.gen();
    public int bJc;
    public boolean cRK = true;
    public boolean cRL = true;
    public String cRM;
    public List<m> cRN;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cRJ;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aoh() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fv(boolean z) {
        this.cRK = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fw(boolean z) {
        this.cRL = z;
    }
}
