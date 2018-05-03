package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a dAb;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.dAb = aVar;
        update();
        awY();
    }

    private void update() {
        if (this.dAb != null && this.dAb.hasData()) {
            List<ICardInfo> aLR = this.dAb.aLR();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aLR);
            this.mHasMore = this.dAb.hasMore();
            this.pn = this.dAb.getPn();
        }
    }

    private void awY() {
        if (this.mThreadList != null) {
            q.o(this.mThreadList, 2);
        }
    }
}
