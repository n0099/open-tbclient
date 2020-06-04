package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
/* loaded from: classes9.dex */
public class c implements o {
    public static final BdUniqueId hYN = BdUniqueId.gen();
    public static final BdUniqueId hYO = BdUniqueId.gen();
    public int hYP;
    public boolean hYQ;
    public boolean hYR;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        switch (this.hYP) {
            case 2:
            case 3:
                return hYO;
            default:
                return hYN;
        }
    }
}
