package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes9.dex */
public class c implements m {
    public static final BdUniqueId gZA = BdUniqueId.gen();
    public static final BdUniqueId gZB = BdUniqueId.gen();
    public int gZC;
    public boolean gZD;
    public boolean gZE;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.gZC) {
            case 2:
            case 3:
                return gZB;
            default:
                return gZA;
        }
    }
}
