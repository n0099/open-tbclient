package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gWv;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gWv = aVar;
        update();
        bMX();
    }

    private void update() {
        if (this.gWv != null && this.gWv.hasData()) {
            List<ICardInfo> ccY = this.gWv.ccY();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(ccY);
            this.mHasMore = this.gWv.hasMore();
            this.pn = this.gWv.getPn();
        }
    }

    private void bMX() {
        if (this.mThreadList != null) {
            s.p(this.mThreadList, 2);
        }
    }
}
