package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gec;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gec = aVar;
        update();
        bvN();
    }

    private void update() {
        if (this.gec != null && this.gec.hasData()) {
            List<ICardInfo> bMr = this.gec.bMr();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bMr);
            this.mHasMore = this.gec.hasMore();
            this.pn = this.gec.getPn();
        }
    }

    private void bvN() {
        if (this.mThreadList != null) {
            s.q(this.mThreadList, 2);
        }
    }
}
