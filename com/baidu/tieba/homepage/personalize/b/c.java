package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.p;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long mTimeStamp;
    public boolean ivB = false;
    public boolean showBottomDivider = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bOT() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mf(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void mg(boolean z) {
        this.showBottomDivider = z;
    }
}
