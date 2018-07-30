package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class a implements h {
    public static final BdUniqueId dTB = BdUniqueId.gen();
    public static final BdUniqueId dTC = BdUniqueId.gen();
    public String atr;
    public int dTD;
    public boolean dTE;
    public boolean dTF;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.dTD) {
            case 2:
            case 3:
                return dTC;
            default:
                return dTB;
        }
    }
}
