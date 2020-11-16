package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a jvf;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.jvf = aVar;
        update();
        cIb();
    }

    private void update() {
        if (this.jvf != null && this.jvf.hasData()) {
            List<ICardInfo> cZC = this.jvf.cZC();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cZC);
            this.mHasMore = this.jvf.hasMore();
            this.pn = this.jvf.getPn();
        }
    }

    private void cIb() {
        if (this.mThreadList != null) {
            u.y(this.mThreadList, 2);
        }
    }
}
