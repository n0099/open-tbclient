package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gcI;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gcI = aVar;
        update();
        bsQ();
    }

    private void update() {
        if (this.gcI != null && this.gcI.hasData()) {
            List<ICardInfo> bIY = this.gcI.bIY();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bIY);
            this.mHasMore = this.gcI.hasMore();
            this.pn = this.gcI.getPn();
        }
    }

    private void bsQ() {
        if (this.mThreadList != null) {
            s.o(this.mThreadList, 2);
        }
    }
}
