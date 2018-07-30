package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a dSv;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.dSv = aVar;
        update();
        aDe();
    }

    private void update() {
        if (this.dSv != null && this.dSv.hasData()) {
            List<ICardInfo> aSv = this.dSv.aSv();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aSv);
            this.mHasMore = this.dSv.hasMore();
            this.pn = this.dSv.getPn();
        }
    }

    private void aDe() {
        if (this.mThreadList != null) {
            q.q(this.mThreadList, 2);
        }
    }
}
