package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a dMs;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.dMs = aVar;
        update();
        aBP();
    }

    private void update() {
        if (this.dMs != null && this.dMs.hasData()) {
            List<ICardInfo> aQN = this.dMs.aQN();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aQN);
            this.mHasMore = this.dMs.hasMore();
            this.pn = this.dMs.getPn();
        }
    }

    private void aBP() {
        if (this.mThreadList != null) {
            q.p(this.mThreadList, 2);
        }
    }
}
