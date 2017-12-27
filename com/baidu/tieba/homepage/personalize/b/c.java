package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.r;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b implements r {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long eeW;
    public boolean showBottomDivider = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean ajP() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eD(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void eE(boolean z) {
        this.showBottomDivider = z;
    }
}
