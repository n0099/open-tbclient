package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes2.dex */
public class a implements i {
    public static final BdUniqueId egC = BdUniqueId.gen();
    public static final BdUniqueId egD = BdUniqueId.gen();
    public String aZJ;
    public int egE;
    public boolean egF;
    public boolean egG;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        switch (this.egE) {
            case 2:
            case 3:
                return egD;
            default:
                return egC;
        }
    }
}
