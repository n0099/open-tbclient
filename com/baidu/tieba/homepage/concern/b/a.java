package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes2.dex */
public class a implements i {
    public static final BdUniqueId eaL = BdUniqueId.gen();
    public static final BdUniqueId eaM = BdUniqueId.gen();
    public String aXT;
    public int eaN;
    public boolean eaO;
    public boolean eaP;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        switch (this.eaN) {
            case 2:
            case 3:
                return eaM;
            default:
                return eaL;
        }
    }
}
