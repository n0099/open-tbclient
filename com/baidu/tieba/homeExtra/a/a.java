package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gbv;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gbv = aVar;
        update();
        buM();
    }

    private void update() {
        if (this.gbv != null && this.gbv.hasData()) {
            List<ICardInfo> bLq = this.gbv.bLq();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bLq);
            this.mHasMore = this.gbv.hasMore();
            this.pn = this.gbv.getPn();
        }
    }

    private void buM() {
        if (this.mThreadList != null) {
            q.q(this.mThreadList, 2);
        }
    }
}
