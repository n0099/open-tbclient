package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a epP;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.epP = aVar;
        update();
        aJV();
    }

    private void update() {
        if (this.epP != null && this.epP.hasData()) {
            List<ICardInfo> aZh = this.epP.aZh();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aZh);
            this.mHasMore = this.epP.hasMore();
            this.pn = this.epP.getPn();
        }
    }

    private void aJV() {
        if (this.mThreadList != null) {
            q.r(this.mThreadList, 2);
        }
    }
}
