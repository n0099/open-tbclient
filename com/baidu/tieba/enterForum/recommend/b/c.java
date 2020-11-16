package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId inT = BdUniqueId.gen();
    public b inU;
    public b inV;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return inT;
    }

    public void a(b bVar) {
        this.inV = bVar;
    }

    public void b(b bVar) {
        this.inU = bVar;
    }
}
