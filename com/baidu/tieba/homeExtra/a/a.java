package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gdz;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gdz = aVar;
        update();
        bsS();
    }

    private void update() {
        if (this.gdz != null && this.gdz.hasData()) {
            List<ICardInfo> bJa = this.gdz.bJa();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(bJa);
            this.mHasMore = this.gdz.hasMore();
            this.pn = this.gdz.getPn();
        }
    }

    private void bsS() {
        if (this.mThreadList != null) {
            s.o(this.mThreadList, 2);
        }
    }
}
