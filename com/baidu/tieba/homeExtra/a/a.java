package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a dZH;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.dZH = aVar;
        update();
        aFo();
    }

    private void update() {
        if (this.dZH != null && this.dZH.hasData()) {
            List<ICardInfo> aUG = this.dZH.aUG();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aUG);
            this.mHasMore = this.dZH.hasMore();
            this.pn = this.dZH.getPn();
        }
    }

    private void aFo() {
        if (this.mThreadList != null) {
            q.q(this.mThreadList, 2);
        }
    }
}
