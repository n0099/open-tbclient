package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a dSq;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.dSq = aVar;
        update();
        aDb();
    }

    private void update() {
        if (this.dSq != null && this.dSq.hasData()) {
            List<ICardInfo> aSs = this.dSq.aSs();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aSs);
            this.mHasMore = this.dSq.hasMore();
            this.pn = this.dSq.getPn();
        }
    }

    private void aDb() {
        if (this.mThreadList != null) {
            q.q(this.mThreadList, 2);
        }
    }
}
