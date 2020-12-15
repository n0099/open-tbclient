package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a jIH;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.jIH = aVar;
        update();
        cNq();
    }

    private void update() {
        if (this.jIH != null && this.jIH.hasData()) {
            List<ICardInfo> deO = this.jIH.deO();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(deO);
            this.mHasMore = this.jIH.hasMore();
            this.pn = this.jIH.getPn();
        }
    }

    private void cNq() {
        if (this.mThreadList != null) {
            v.y(this.mThreadList, 2);
        }
    }
}
