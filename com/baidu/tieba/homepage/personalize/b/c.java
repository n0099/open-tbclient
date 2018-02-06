package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.q;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b implements q {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long ekU;
    public boolean showBottomDivider = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean alG() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eQ(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void eR(boolean z) {
        this.showBottomDivider = z;
    }
}
