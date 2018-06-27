package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a dPI;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.dPI = aVar;
        update();
        aCv();
    }

    private void update() {
        if (this.dPI != null && this.dPI.hasData()) {
            List<ICardInfo> aRt = this.dPI.aRt();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aRt);
            this.mHasMore = this.dPI.hasMore();
            this.pn = this.dPI.getPn();
        }
    }

    private void aCv() {
        if (this.mThreadList != null) {
            q.q(this.mThreadList, 2);
        }
    }
}
