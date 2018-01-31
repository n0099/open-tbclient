package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.r;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b implements r {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long egI;
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
    public boolean akX() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eJ(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void eK(boolean z) {
        this.showBottomDivider = z;
    }
}
