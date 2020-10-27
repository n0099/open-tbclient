package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a joB;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.joB = aVar;
        update();
        cFV();
    }

    private void update() {
        if (this.joB != null && this.joB.hasData()) {
            List<ICardInfo> cXE = this.joB.cXE();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cXE);
            this.mHasMore = this.joB.hasMore();
            this.pn = this.joB.getPn();
        }
    }

    private void cFV() {
        if (this.mThreadList != null) {
            u.y(this.mThreadList, 2);
        }
    }
}
