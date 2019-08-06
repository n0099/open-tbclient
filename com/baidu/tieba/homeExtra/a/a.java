package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gcl;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gcl = aVar;
        update();
        buZ();
    }

    private void update() {
        if (this.gcl != null && this.gcl.hasData()) {
            List<ICardInfo> bLE = this.gcl.bLE();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bLE);
            this.mHasMore = this.gcl.hasMore();
            this.pn = this.gcl.getPn();
        }
    }

    private void buZ() {
        if (this.mThreadList != null) {
            s.q(this.mThreadList, 2);
        }
    }
}
