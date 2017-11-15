package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class a implements f {
    public static final BdUniqueId deM = BdUniqueId.gen();
    public static final BdUniqueId deN = BdUniqueId.gen();
    public String ajo;
    public int deO;
    public boolean deP;
    public boolean deQ;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        switch (this.deO) {
            case 2:
            case 3:
                return deN;
            default:
                return deM;
        }
    }
}
