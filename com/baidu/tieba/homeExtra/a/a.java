package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a efy;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.efy = aVar;
        update();
        aCc();
    }

    private void update() {
        if (this.efy != null && this.efy.hasData()) {
            List<ICardInfo> aQS = this.efy.aQS();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aQS);
            this.mHasMore = this.efy.hasMore();
            this.pn = this.efy.getPn();
        }
    }

    private void aCc() {
        if (this.mThreadList != null) {
            r.s(this.mThreadList, 2);
        }
    }
}
