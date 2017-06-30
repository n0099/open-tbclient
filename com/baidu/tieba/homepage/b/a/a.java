package com.baidu.tieba.homepage.b.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public class a extends b {
    public static final BdUniqueId cLn = BdUniqueId.gen();
    public String cLo;
    public long cLp;
    public boolean isSelected;
    public int level;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cLn;
    }
}
