package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a jVR;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.jVR = aVar;
        update();
        cQx();
    }

    private void update() {
        if (this.jVR != null && this.jVR.hasData()) {
            List<ICardInfo> deA = this.jVR.deA();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(deA);
            this.mHasMore = this.jVR.hasMore();
            this.pn = this.jVR.getPn();
        }
    }

    private void cQx() {
        if (this.mThreadList != null) {
            v.y(this.mThreadList, 2);
        }
    }
}
