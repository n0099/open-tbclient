package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a fWy;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.fWy = aVar;
        update();
        bsL();
    }

    private void update() {
        if (this.fWy != null && this.fWy.hasData()) {
            List<ICardInfo> bIJ = this.fWy.bIJ();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bIJ);
            this.mHasMore = this.fWy.hasMore();
            this.pn = this.fWy.getPn();
        }
    }

    private void bsL() {
        if (this.mThreadList != null) {
            q.q(this.mThreadList, 2);
        }
    }
}
