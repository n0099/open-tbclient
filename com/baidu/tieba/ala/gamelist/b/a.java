package com.baidu.tieba.ala.gamelist.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.card.data.b;
/* loaded from: classes4.dex */
public class a extends b {
    public static final BdUniqueId fPx = BdUniqueId.gen();
    public bw gcA;
    public bw gcB;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fPx;
    }
}
