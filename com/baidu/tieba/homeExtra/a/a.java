package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a jZc;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.jZc = aVar;
        update();
        cOJ();
    }

    private void update() {
        if (this.jZc != null && this.jZc.hasData()) {
            List<ICardInfo> dcN = this.jZc.dcN();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(dcN);
            this.mHasMore = this.jZc.hasMore();
            this.pn = this.jZc.getPn();
        }
    }

    private void cOJ() {
        if (this.mThreadList != null) {
            v.y(this.mThreadList, 2);
        }
    }
}
