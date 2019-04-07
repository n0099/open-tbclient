package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a fFy;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.fFy = aVar;
        update();
        blm();
    }

    private void update() {
        if (this.fFy != null && this.fFy.hasData()) {
            List<ICardInfo> bAV = this.fFy.bAV();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bAV);
            this.mHasMore = this.fFy.hasMore();
            this.pn = this.fFy.getPn();
        }
    }

    private void blm() {
        if (this.mThreadList != null) {
            q.q(this.mThreadList, 2);
        }
    }
}
