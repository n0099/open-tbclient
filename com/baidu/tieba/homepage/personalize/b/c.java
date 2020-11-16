package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.p;
/* loaded from: classes21.dex */
public class c extends BaseCardInfo implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long mTimeStamp;
    public boolean jHG = false;
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
    public boolean cop() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void oE(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void oF(boolean z) {
        this.showBottomDivider = z;
    }
}
