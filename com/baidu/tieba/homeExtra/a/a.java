package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a efu;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.efu = aVar;
        update();
        aCc();
    }

    private void update() {
        if (this.efu != null && this.efu.hasData()) {
            List<ICardInfo> aQS = this.efu.aQS();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aQS);
            this.mHasMore = this.efu.hasMore();
            this.pn = this.efu.getPn();
        }
    }

    private void aCc() {
        if (this.mThreadList != null) {
            q.s(this.mThreadList, 2);
        }
    }
}
