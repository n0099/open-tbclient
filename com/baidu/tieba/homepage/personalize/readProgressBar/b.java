package com.baidu.tieba.homepage.personalize.readProgressBar;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.p;
/* loaded from: classes2.dex */
public class b extends BaseCardInfo implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long mTimeStamp;
    public boolean kix = false;
    public boolean showBottomDivider = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cvw() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void py(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pz(boolean z) {
        this.showBottomDivider = z;
    }
}
