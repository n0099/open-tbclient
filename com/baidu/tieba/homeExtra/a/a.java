package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a ilt;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.ilt = aVar;
        update();
        chP();
    }

    private void update() {
        if (this.ilt != null && this.ilt.hasData()) {
            List<ICardInfo> cyr = this.ilt.cyr();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cyr);
            this.mHasMore = this.ilt.hasMore();
            this.pn = this.ilt.getPn();
        }
    }

    private void chP() {
        if (this.mThreadList != null) {
            t.u(this.mThreadList, 2);
        }
    }
}
