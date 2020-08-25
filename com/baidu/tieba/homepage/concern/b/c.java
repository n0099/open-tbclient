package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes16.dex */
public class c implements q {
    public static final BdUniqueId iHI = BdUniqueId.gen();
    public static final BdUniqueId iHJ = BdUniqueId.gen();
    public int iHK;
    public boolean iHL;
    public boolean iHM;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.iHK) {
            case 2:
            case 3:
                return iHJ;
            default:
                return iHI;
        }
    }
}
