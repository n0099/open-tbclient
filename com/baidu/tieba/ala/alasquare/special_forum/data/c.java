package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public List<b> ftI;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
