package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a etn;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.etn = aVar;
        update();
        aLi();
    }

    private void update() {
        if (this.etn != null && this.etn.hasData()) {
            List<ICardInfo> bav = this.etn.bav();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bav);
            this.mHasMore = this.etn.hasMore();
            this.pn = this.etn.getPn();
        }
    }

    private void aLi() {
        if (this.mThreadList != null) {
            q.r(this.mThreadList, 2);
        }
    }
}
