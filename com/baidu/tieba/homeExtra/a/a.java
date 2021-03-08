package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a kbe;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.kbe = aVar;
        update();
        cOQ();
    }

    private void update() {
        if (this.kbe != null && this.kbe.hasData()) {
            List<ICardInfo> dcW = this.kbe.dcW();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(dcW);
            this.mHasMore = this.kbe.hasMore();
            this.pn = this.kbe.getPn();
        }
    }

    private void cOQ() {
        if (this.mThreadList != null) {
            v.y(this.mThreadList, 2);
        }
    }
}
