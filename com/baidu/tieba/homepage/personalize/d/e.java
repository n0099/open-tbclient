package com.baidu.tieba.homepage.personalize.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.s;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b implements s {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long csw;
    public boolean showBottomDivider = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean OO() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.s
    public void cB(boolean z) {
        this.showBottomDivider = z;
    }
}
