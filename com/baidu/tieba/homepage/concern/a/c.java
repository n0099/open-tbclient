package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes21.dex */
public class c implements q {
    public static final BdUniqueId iPE = BdUniqueId.gen();
    public static final BdUniqueId iPF = BdUniqueId.gen();
    public int iPG;
    public boolean iPH;
    public boolean iPI;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.iPG) {
            case 2:
            case 3:
                return iPF;
            default:
                return iPE;
        }
    }
}
