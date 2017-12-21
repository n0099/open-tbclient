package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b implements r {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long dsQ;
    public boolean showBottomDivider = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean acj() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dX(boolean z) {
        this.showBottomDivider = z;
    }
}
