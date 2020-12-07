package com.baidu.tieba.ala.gamelist.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes6.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId gzw = BdUniqueId.gen();
    public by gNo;
    public by gNp;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gzw;
    }
}
