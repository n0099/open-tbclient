package com.baidu.tieba.ala.gamelist.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId grn = BdUniqueId.gen();
    public bx gEr;
    public bx gEs;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return grn;
    }
}
