package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a jIF;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.jIF = aVar;
        update();
        cNp();
    }

    private void update() {
        if (this.jIF != null && this.jIF.hasData()) {
            List<ICardInfo> deN = this.jIF.deN();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(deN);
            this.mHasMore = this.jIF.hasMore();
            this.pn = this.jIF.getPn();
        }
    }

    private void cNp() {
        if (this.mThreadList != null) {
            v.y(this.mThreadList, 2);
        }
    }
}
