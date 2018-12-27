package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a esG;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.esG = aVar;
        update();
        aKK();
    }

    private void update() {
        if (this.esG != null && this.esG.hasData()) {
            List<ICardInfo> aZV = this.esG.aZV();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aZV);
            this.mHasMore = this.esG.hasMore();
            this.pn = this.esG.getPn();
        }
    }

    private void aKK() {
        if (this.mThreadList != null) {
            q.r(this.mThreadList, 2);
        }
    }
}
