package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends b implements p {
    public static final BdUniqueId gHP = BdUniqueId.gen();
    public boolean gHQ = true;
    public boolean gHR = true;
    public String gHS;
    public List<m> gHT;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gHP;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bLG() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lW(boolean z) {
        this.gHQ = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lX(boolean z) {
        this.gHR = z;
    }
}
