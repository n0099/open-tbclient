package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a iFT;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.iFT = aVar;
        update();
        cvY();
    }

    private void update() {
        if (this.iFT != null && this.iFT.hasData()) {
            List<ICardInfo> cNi = this.iFT.cNi();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cNi);
            this.mHasMore = this.iFT.hasMore();
            this.pn = this.iFT.getPn();
        }
    }

    private void cvY() {
        if (this.mThreadList != null) {
            u.v(this.mThreadList, 2);
        }
    }
}
