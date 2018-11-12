package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a eiV;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.eiV = aVar;
        update();
        aIe();
    }

    private void update() {
        if (this.eiV != null && this.eiV.hasData()) {
            List<ICardInfo> aXq = this.eiV.aXq();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aXq);
            this.mHasMore = this.eiV.hasMore();
            this.pn = this.eiV.getPn();
        }
    }

    private void aIe() {
        if (this.mThreadList != null) {
            q.r(this.mThreadList, 2);
        }
    }
}
