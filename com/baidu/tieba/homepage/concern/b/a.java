package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class a implements h {
    public static final BdUniqueId dCq = BdUniqueId.gen();
    public static final BdUniqueId dCr = BdUniqueId.gen();
    public String alc;
    public int dCs;
    public boolean dCt;
    public boolean dCu;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.dCs) {
            case 2:
            case 3:
                return dCr;
            default:
                return dCq;
        }
    }
}
