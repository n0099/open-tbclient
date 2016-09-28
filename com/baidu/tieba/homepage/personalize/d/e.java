package com.baidu.tieba.homepage.personalize.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.s;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b implements s {
    public static final BdUniqueId Ru = BdUniqueId.gen();
    public long mTimeStamp;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ru;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean Op() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void ct(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.s
    public void cu(boolean z) {
    }
}
