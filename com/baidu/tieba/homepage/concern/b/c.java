package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
/* loaded from: classes9.dex */
public class c implements o {
    public static final BdUniqueId hYa = BdUniqueId.gen();
    public static final BdUniqueId hYb = BdUniqueId.gen();
    public int hYc;
    public boolean hYd;
    public boolean hYe;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        switch (this.hYc) {
            case 2:
            case 3:
                return hYb;
            default:
                return hYa;
        }
    }
}
