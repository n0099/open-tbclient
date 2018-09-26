package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends b implements p {
    public static final BdUniqueId cIk = BdUniqueId.gen();
    public int bzJ;
    public boolean cIl = true;
    public boolean cIm = true;
    public String cIn;
    public List<m> cIo;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cIk;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ald() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eS(boolean z) {
        this.cIl = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eT(boolean z) {
        this.cIm = z;
    }
}
