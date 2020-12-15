package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.p;
/* loaded from: classes22.dex */
public class c extends BaseCardInfo implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long mTimeStamp;
    public boolean jVl = false;
    public boolean showBottomDivider = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csD() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pa(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pb(boolean z) {
        this.showBottomDivider = z;
    }
}
