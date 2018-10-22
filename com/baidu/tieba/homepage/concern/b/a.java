package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes6.dex */
public class a implements h {
    public static final BdUniqueId eiJ = BdUniqueId.gen();
    public static final BdUniqueId eiK = BdUniqueId.gen();
    public String aBr;
    public int eiL;
    public boolean eiM;
    public boolean eiN;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.eiL) {
            case 2:
            case 3:
                return eiK;
            default:
                return eiJ;
        }
    }
}
