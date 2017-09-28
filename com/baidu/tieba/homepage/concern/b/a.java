package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class a implements f {
    public static final BdUniqueId cWo = BdUniqueId.gen();
    public static final BdUniqueId cWp = BdUniqueId.gen();
    public String aje;
    public int cWq;
    public boolean cWr;
    public boolean cWs;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        switch (this.cWq) {
            case 2:
            case 3:
                return cWp;
            default:
                return cWo;
        }
    }
}
