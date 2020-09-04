package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes16.dex */
public class c implements q {
    public static final BdUniqueId iHO = BdUniqueId.gen();
    public static final BdUniqueId iHP = BdUniqueId.gen();
    public int iHQ;
    public boolean iHR;
    public boolean iHS;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.iHQ) {
            case 2:
            case 3:
                return iHP;
            default:
                return iHO;
        }
    }
}
