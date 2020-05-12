package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a hHz;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.hHz = aVar;
        update();
        bXL();
    }

    private void update() {
        if (this.hHz != null && this.hHz.hasData()) {
            List<ICardInfo> cnQ = this.hHz.cnQ();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cnQ);
            this.mHasMore = this.hHz.hasMore();
            this.pn = this.hHz.getPn();
        }
    }

    private void bXL() {
        if (this.mThreadList != null) {
            t.r(this.mThreadList, 2);
        }
    }
}
