package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.t;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b implements t {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long mTimeStamp;
    public boolean showBottomDivider = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean Ta() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cR(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.t
    public void cS(boolean z) {
        this.showBottomDivider = z;
    }
}
