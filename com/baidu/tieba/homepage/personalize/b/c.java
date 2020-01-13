package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.p;
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.card.data.b implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public long mTimeStamp;
    public boolean hdr = false;
    public boolean showBottomDivider = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean btQ() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kq(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kr(boolean z) {
        this.showBottomDivider = z;
    }
}
