package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a fFK;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.fFK = aVar;
        update();
        blp();
    }

    private void update() {
        if (this.fFK != null && this.fFK.hasData()) {
            List<ICardInfo> bAY = this.fFK.bAY();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bAY);
            this.mHasMore = this.fFK.hasMore();
            this.pn = this.fFK.getPn();
        }
    }

    private void blp() {
        if (this.mThreadList != null) {
            q.q(this.mThreadList, 2);
        }
    }
}
