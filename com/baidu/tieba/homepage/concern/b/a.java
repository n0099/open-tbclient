package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes6.dex */
public class a implements h {
    public static final BdUniqueId eiI = BdUniqueId.gen();
    public static final BdUniqueId eiJ = BdUniqueId.gen();
    public String aBr;
    public int eiK;
    public boolean eiL;
    public boolean eiM;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.eiK) {
            case 2:
            case 3:
                return eiJ;
            default:
                return eiI;
        }
    }
}
