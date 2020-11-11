package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a juy;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.juy = aVar;
        update();
        cIw();
    }

    private void update() {
        if (this.juy != null && this.juy.hasData()) {
            List<ICardInfo> daf = this.juy.daf();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(daf);
            this.mHasMore = this.juy.hasMore();
            this.pn = this.juy.getPn();
        }
    }

    private void cIw() {
        if (this.mThreadList != null) {
            u.y(this.mThreadList, 2);
        }
    }
}
