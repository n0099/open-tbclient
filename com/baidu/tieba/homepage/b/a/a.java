package com.baidu.tieba.homepage.b.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public class a extends b {
    public static final BdUniqueId cXj = BdUniqueId.gen();
    public String cXk;
    public long cXl;
    public boolean isSelected;
    public int level;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cXj;
    }
}
