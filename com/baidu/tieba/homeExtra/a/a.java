package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gUg;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gUg = aVar;
        update();
        bLr();
    }

    private void update() {
        if (this.gUg != null && this.gUg.hasData()) {
            List<ICardInfo> cbu = this.gUg.cbu();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cbu);
            this.mHasMore = this.gUg.hasMore();
            this.pn = this.gUg.getPn();
        }
    }

    private void bLr() {
        if (this.mThreadList != null) {
            s.p(this.mThreadList, 2);
        }
    }
}
