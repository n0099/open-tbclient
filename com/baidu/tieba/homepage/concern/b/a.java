package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class a implements f {
    public static final BdUniqueId cWc = BdUniqueId.gen();
    public static final BdUniqueId cWd = BdUniqueId.gen();
    public String aiS;
    public int cWe;
    public boolean cWf;
    public boolean cWg;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        switch (this.cWe) {
            case 2:
            case 3:
                return cWd;
            default:
                return cWc;
        }
    }
}
