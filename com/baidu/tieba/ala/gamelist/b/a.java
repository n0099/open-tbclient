package com.baidu.tieba.ala.gamelist.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.card.data.b;
/* loaded from: classes4.dex */
public class a extends b {
    public static final BdUniqueId fAN = BdUniqueId.gen();
    public bv fNk;
    public bv fNl;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fAN;
    }
}
