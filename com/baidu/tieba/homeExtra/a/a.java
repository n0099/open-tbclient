package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a dAe;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.dAe = aVar;
        update();
        awY();
    }

    private void update() {
        if (this.dAe != null && this.dAe.hasData()) {
            List<ICardInfo> aLR = this.dAe.aLR();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aLR);
            this.mHasMore = this.dAe.hasMore();
            this.pn = this.dAe.getPn();
        }
    }

    private void awY() {
        if (this.mThreadList != null) {
            q.o(this.mThreadList, 2);
        }
    }
}
