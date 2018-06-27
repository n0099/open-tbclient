package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends b implements p {
    public static final BdUniqueId czR = BdUniqueId.gen();
    public int btk;
    public boolean czS = true;
    public boolean czT = true;
    public String czU;
    public List<m> czV;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return czR;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aiQ() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eA(boolean z) {
        this.czS = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
        this.czT = z;
    }
}
