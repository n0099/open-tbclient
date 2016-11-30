package com.baidu.tieba.homepage.personalize.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.s;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b implements s {
    public static final BdUniqueId RQ = BdUniqueId.gen();
    public long mTimeStamp;
    public boolean showBottomDivider = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RQ;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean Ps() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cy(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.s
    public void cz(boolean z) {
        this.showBottomDivider = z;
    }
}
