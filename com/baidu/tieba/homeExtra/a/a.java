package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a ilt;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.ilt = aVar;
        update();
        chO();
    }

    private void update() {
        if (this.ilt != null && this.ilt.hasData()) {
            List<ICardInfo> cyq = this.ilt.cyq();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cyq);
            this.mHasMore = this.ilt.hasMore();
            this.pn = this.ilt.getPn();
        }
    }

    private void chO() {
        if (this.mThreadList != null) {
            t.u(this.mThreadList, 2);
        }
    }
}
