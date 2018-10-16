package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a ehA;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.ehA = aVar;
        update();
        aIG();
    }

    private void update() {
        if (this.ehA != null && this.ehA.hasData()) {
            List<ICardInfo> aXT = this.ehA.aXT();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aXT);
            this.mHasMore = this.ehA.hasMore();
            this.pn = this.ehA.getPn();
        }
    }

    private void aIG() {
        if (this.mThreadList != null) {
            q.r(this.mThreadList, 2);
        }
    }
}
