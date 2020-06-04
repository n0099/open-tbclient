package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a hWY;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.hWY = aVar;
        update();
        cer();
    }

    private void update() {
        if (this.hWY != null && this.hWY.hasData()) {
            List<ICardInfo> cuB = this.hWY.cuB();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cuB);
            this.mHasMore = this.hWY.hasMore();
            this.pn = this.hWY.getPn();
        }
    }

    private void cer() {
        if (this.mThreadList != null) {
            t.t(this.mThreadList, 2);
        }
    }
}
