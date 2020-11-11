package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class c implements q {
    public static final BdUniqueId jwT = BdUniqueId.gen();
    public static final BdUniqueId jwU = BdUniqueId.gen();
    public int jwV;
    public boolean jwW;
    public boolean jwX;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.jwV) {
            case 2:
            case 3:
                return jwU;
            default:
                return jwT;
        }
    }
}
