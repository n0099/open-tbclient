package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a iFN;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.iFN = aVar;
        update();
        cvX();
    }

    private void update() {
        if (this.iFN != null && this.iFN.hasData()) {
            List<ICardInfo> cNh = this.iFN.cNh();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cNh);
            this.mHasMore = this.iFN.hasMore();
            this.pn = this.iFN.getPn();
        }
    }

    private void cvX() {
        if (this.mThreadList != null) {
            u.v(this.mThreadList, 2);
        }
    }
}
