package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a iry;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.iry = aVar;
        update();
        clo();
    }

    private void update() {
        if (this.iry != null && this.iry.hasData()) {
            List<ICardInfo> cCp = this.iry.cCp();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cCp);
            this.mHasMore = this.iry.hasMore();
            this.pn = this.iry.getPn();
        }
    }

    private void clo() {
        if (this.mThreadList != null) {
            t.s(this.mThreadList, 2);
        }
    }
}
