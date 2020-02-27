package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gWh;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gWh = aVar;
        update();
        bMU();
    }

    private void update() {
        if (this.gWh != null && this.gWh.hasData()) {
            List<ICardInfo> ccV = this.gWh.ccV();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(ccV);
            this.mHasMore = this.gWh.hasMore();
            this.pn = this.gWh.getPn();
        }
    }

    private void bMU() {
        if (this.mThreadList != null) {
            s.p(this.mThreadList, 2);
        }
    }
}
