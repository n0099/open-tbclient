package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a eto;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.eto = aVar;
        update();
        aLi();
    }

    private void update() {
        if (this.eto != null && this.eto.hasData()) {
            List<ICardInfo> bav = this.eto.bav();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bav);
            this.mHasMore = this.eto.hasMore();
            this.pn = this.eto.getPn();
        }
    }

    private void aLi() {
        if (this.mThreadList != null) {
            q.r(this.mThreadList, 2);
        }
    }
}
