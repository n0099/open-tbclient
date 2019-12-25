package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a gQM;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.gQM = aVar;
        update();
        bKm();
    }

    private void update() {
        if (this.gQM != null && this.gQM.hasData()) {
            List<ICardInfo> cal = this.gQM.cal();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cal);
            this.mHasMore = this.gQM.hasMore();
            this.pn = this.gQM.getPn();
        }
    }

    private void bKm() {
        if (this.mThreadList != null) {
            s.o(this.mThreadList, 2);
        }
    }
}
