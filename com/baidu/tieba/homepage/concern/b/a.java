package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId gdI = BdUniqueId.gen();
    public static final BdUniqueId gdJ = BdUniqueId.gen();
    public String bXs;
    public int gdK;
    public boolean gdL;
    public boolean gdM;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.gdK) {
            case 2:
            case 3:
                return gdJ;
            default:
                return gdI;
        }
    }
}
