package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.a.s;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a.b implements s {
    public static final BdUniqueId Op = BdUniqueId.gen();
    public long mTimeStamp;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Op;
    }

    @Override // com.baidu.tieba.card.a.s
    public int getPosition() {
        return 0;
    }

    @Override // com.baidu.tieba.card.a.s
    public boolean Lm() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.s
    public void ck(boolean z) {
    }
}
