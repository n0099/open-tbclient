package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a fWw;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.fWw = aVar;
        update();
        bsJ();
    }

    private void update() {
        if (this.fWw != null && this.fWw.hasData()) {
            List<ICardInfo> bII = this.fWw.bII();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bII);
            this.mHasMore = this.fWw.hasMore();
            this.pn = this.fWw.getPn();
        }
    }

    private void bsJ() {
        if (this.mThreadList != null) {
            q.q(this.mThreadList, 2);
        }
    }
}
