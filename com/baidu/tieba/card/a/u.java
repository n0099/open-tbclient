package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class u extends b implements w {
    public static final BdUniqueId aSH = BdUniqueId.gen();
    public boolean aRQ = true;
    public String aSI;
    public List<t> aSJ;
    public int aSK;
    public int position;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aSH;
    }

    @Override // com.baidu.tieba.card.a.w
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.a.w
    public boolean Kk() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.w
    public void bT(boolean z) {
        this.aRQ = z;
    }
}
