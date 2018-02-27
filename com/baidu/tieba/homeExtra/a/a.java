package com.baidu.tieba.homeExtra.a;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.homepage.a.a.a {
    private com.baidu.tieba.lego.c.a efi;

    public void a(com.baidu.tieba.lego.c.a aVar) {
        this.efi = aVar;
        update();
        aCb();
    }

    private void update() {
        if (this.efi != null && this.efi.hasData()) {
            List<ICardInfo> aQR = this.efi.aQR();
            this.mThreadList = new ArrayList();
            this.mThreadList.addAll(aQR);
            this.mHasMore = this.efi.hasMore();
            this.pn = this.efi.getPn();
        }
    }

    private void aCb() {
        if (this.mThreadList != null) {
            q.s(this.mThreadList, 2);
        }
    }
}
