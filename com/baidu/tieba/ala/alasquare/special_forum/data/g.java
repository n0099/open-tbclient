package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fpr = BdUniqueId.gen();
    public boolean ftM;
    public String ftN;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fpr;
    }
}
