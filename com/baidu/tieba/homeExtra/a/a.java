package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a iNo;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.iNo = aVar;
        update();
        czr();
    }

    private void update() {
        if (this.iNo != null && this.iNo.hasData()) {
            List<ICardInfo> cQN = this.iNo.cQN();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cQN);
            this.mHasMore = this.iNo.hasMore();
            this.pn = this.iNo.getPn();
        }
    }

    private void czr() {
        if (this.mThreadList != null) {
            u.v(this.mThreadList, 2);
        }
    }
}
