package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends b implements p {
    public static final BdUniqueId gIa = BdUniqueId.gen();
    public boolean gIb = true;
    public boolean gIc = true;
    public String gId;
    public List<m> gIe;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gIa;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bLI() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lW(boolean z) {
        this.gIb = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lX(boolean z) {
        this.gIc = z;
    }
}
