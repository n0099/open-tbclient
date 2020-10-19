package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.q;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.data.b implements q {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long mTimeStamp;
    public boolean jok = false;
    public boolean showBottomDivider = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cjc() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void oa(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void ob(boolean z) {
        this.showBottomDivider = z;
    }
}
