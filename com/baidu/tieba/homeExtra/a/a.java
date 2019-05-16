package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a fWv;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.fWv = aVar;
        update();
        bsG();
    }

    private void update() {
        if (this.fWv != null && this.fWv.hasData()) {
            List<ICardInfo> bIF = this.fWv.bIF();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bIF);
            this.mHasMore = this.fWv.hasMore();
            this.pn = this.fWv.getPn();
        }
    }

    private void bsG() {
        if (this.mThreadList != null) {
            q.q(this.mThreadList, 2);
        }
    }
}
