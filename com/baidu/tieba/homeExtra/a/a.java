package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a hWl;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.hWl = aVar;
        update();
        cej();
    }

    private void update() {
        if (this.hWl != null && this.hWl.hasData()) {
            List<ICardInfo> cus = this.hWl.cus();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cus);
            this.mHasMore = this.hWl.hasMore();
            this.pn = this.hWl.getPn();
        }
    }

    private void cej() {
        if (this.mThreadList != null) {
            t.t(this.mThreadList, 2);
        }
    }
}
