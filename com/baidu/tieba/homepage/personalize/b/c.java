package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.p;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long bcI;
    public boolean gnE = false;
    public boolean showBottomDivider = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baK() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iK(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void iL(boolean z) {
        this.showBottomDivider = z;
    }
}
