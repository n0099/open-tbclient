package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId iyL = BdUniqueId.gen();
    public b iyM;
    public b iyN;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iyL;
    }

    public void a(b bVar) {
        this.iyN = bVar;
    }

    public void b(b bVar) {
        this.iyM = bVar;
    }
}
