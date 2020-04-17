package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a hHt;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.hHt = aVar;
        update();
        bXM();
    }

    private void update() {
        if (this.hHt != null && this.hHt.hasData()) {
            List<ICardInfo> cnS = this.hHt.cnS();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(cnS);
            this.mHasMore = this.hHt.hasMore();
            this.pn = this.hHt.getPn();
        }
    }

    private void bXM() {
        if (this.mThreadList != null) {
            t.r(this.mThreadList, 2);
        }
    }
}
