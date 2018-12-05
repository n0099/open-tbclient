package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes6.dex */
public class a implements h {
    public static final BdUniqueId eqX = BdUniqueId.gen();
    public static final BdUniqueId eqY = BdUniqueId.gen();
    public String aFG;
    public int eqZ;
    public boolean era;
    public boolean erb;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.eqZ) {
            case 2:
            case 3:
                return eqY;
            default:
                return eqX;
        }
    }
}
