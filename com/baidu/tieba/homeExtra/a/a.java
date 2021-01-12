package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a jRm;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.jRm = aVar;
        update();
        cMF();
    }

    private void update() {
        if (this.jRm != null && this.jRm.hasData()) {
            List<ICardInfo> daI = this.jRm.daI();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(daI);
            this.mHasMore = this.jRm.hasMore();
            this.pn = this.jRm.getPn();
        }
    }

    private void cMF() {
        if (this.mThreadList != null) {
            v.y(this.mThreadList, 2);
        }
    }
}
