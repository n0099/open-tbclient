package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class a implements h {
    public static final BdUniqueId eaP = BdUniqueId.gen();
    public static final BdUniqueId eaQ = BdUniqueId.gen();
    public String awG;
    public int eaR;
    public boolean eaS;
    public boolean eaT;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.eaR) {
            case 2:
            case 3:
                return eaQ;
            default:
                return eaP;
        }
    }
}
