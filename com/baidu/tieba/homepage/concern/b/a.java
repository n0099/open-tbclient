package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes2.dex */
public class a implements i {
    public static final BdUniqueId egG = BdUniqueId.gen();
    public static final BdUniqueId egH = BdUniqueId.gen();
    public String aZz;
    public int egI;
    public boolean egJ;
    public boolean egK;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        switch (this.egI) {
            case 2:
            case 3:
                return egH;
            default:
                return egG;
        }
    }
}
