package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes2.dex */
public class a implements i {
    public static final BdUniqueId ebV = BdUniqueId.gen();
    public static final BdUniqueId ebW = BdUniqueId.gen();
    public String aXS;
    public int ebX;
    public boolean ebY;
    public boolean ebZ;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        switch (this.ebX) {
            case 2:
            case 3:
                return ebW;
            default:
                return ebV;
        }
    }
}
