package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a dBi;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.dBi = aVar;
        update();
        awX();
    }

    private void update() {
        if (this.dBi != null && this.dBi.hasData()) {
            List<ICardInfo> aLQ = this.dBi.aLQ();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aLQ);
            this.mHasMore = this.dBi.hasMore();
            this.pn = this.dBi.getPn();
        }
    }

    private void awX() {
        if (this.mThreadList != null) {
            q.o(this.mThreadList, 2);
        }
    }
}
