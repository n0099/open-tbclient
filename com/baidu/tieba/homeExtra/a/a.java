package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a irw;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.irw = aVar;
        update();
        clo();
    }

    private void update() {
        if (this.irw != null && this.irw.hasData()) {
            List<ICardInfo> cCp = this.irw.cCp();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cCp);
            this.mHasMore = this.irw.hasMore();
            this.pn = this.irw.getPn();
        }
    }

    private void clo() {
        if (this.mThreadList != null) {
            t.s(this.mThreadList, 2);
        }
    }
}
