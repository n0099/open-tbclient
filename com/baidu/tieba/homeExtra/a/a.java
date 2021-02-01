package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a jYO;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.jYO = aVar;
        update();
        cOC();
    }

    private void update() {
        if (this.jYO != null && this.jYO.hasData()) {
            List<ICardInfo> dcG = this.jYO.dcG();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(dcG);
            this.mHasMore = this.jYO.hasMore();
            this.pn = this.jYO.getPn();
        }
    }

    private void cOC() {
        if (this.mThreadList != null) {
            v.y(this.mThreadList, 2);
        }
    }
}
