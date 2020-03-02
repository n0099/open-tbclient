package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gWj;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gWj = aVar;
        update();
        bMW();
    }

    private void update() {
        if (this.gWj != null && this.gWj.hasData()) {
            List<ICardInfo> ccX = this.gWj.ccX();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(ccX);
            this.mHasMore = this.gWj.hasMore();
            this.pn = this.gWj.getPn();
        }
    }

    private void bMW() {
        if (this.mThreadList != null) {
            s.p(this.mThreadList, 2);
        }
    }
}
