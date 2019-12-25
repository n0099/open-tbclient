package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes6.dex */
public class c implements m {
    public static final BdUniqueId gSK = BdUniqueId.gen();
    public static final BdUniqueId gSL = BdUniqueId.gen();
    public int gSM;
    public boolean gSN;
    public boolean gSO;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.gSM) {
            case 2:
            case 3:
                return gSL;
            default:
                return gSK;
        }
    }
}
