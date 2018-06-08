package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.p;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long dRW;
    public boolean showBottomDivider = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ajw() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
        this.showBottomDivider = z;
    }
}
