package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class a implements f {
    public static final BdUniqueId der = BdUniqueId.gen();
    public static final BdUniqueId det = BdUniqueId.gen();
    public String ajo;
    public int deu;
    public boolean dev;
    public boolean dew;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        switch (this.deu) {
            case 2:
            case 3:
                return det;
            default:
                return der;
        }
    }
}
