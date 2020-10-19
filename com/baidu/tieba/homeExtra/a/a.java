package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a jcg;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.jcg = aVar;
        update();
        cCO();
    }

    private void update() {
        if (this.jcg != null && this.jcg.hasData()) {
            List<ICardInfo> cUx = this.jcg.cUx();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cUx);
            this.mHasMore = this.jcg.hasMore();
            this.pn = this.jcg.getPn();
        }
    }

    private void cCO() {
        if (this.mThreadList != null) {
            u.x(this.mThreadList, 2);
        }
    }
}
