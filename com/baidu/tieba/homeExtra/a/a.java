package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gXC;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gXC = aVar;
        update();
        bNl();
    }

    private void update() {
        if (this.gXC != null && this.gXC.hasData()) {
            List<ICardInfo> cdr = this.gXC.cdr();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cdr);
            this.mHasMore = this.gXC.hasMore();
            this.pn = this.gXC.getPn();
        }
    }

    private void bNl() {
        if (this.mThreadList != null) {
            t.o(this.mThreadList, 2);
        }
    }
}
