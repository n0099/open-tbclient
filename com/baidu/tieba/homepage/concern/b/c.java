package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes7.dex */
public class c implements m {
    public static final BdUniqueId gWe = BdUniqueId.gen();
    public static final BdUniqueId gWf = BdUniqueId.gen();
    public int gWg;
    public boolean gWh;
    public boolean gWi;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.gWg) {
            case 2:
            case 3:
                return gWf;
            default:
                return gWe;
        }
    }
}
