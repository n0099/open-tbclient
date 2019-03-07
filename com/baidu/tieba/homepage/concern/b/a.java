package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId fGU = BdUniqueId.gen();
    public static final BdUniqueId fGV = BdUniqueId.gen();
    public String bOr;
    public int fGW;
    public boolean fGX;
    public boolean fGY;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.fGW) {
            case 2:
            case 3:
                return fGV;
            default:
                return fGU;
        }
    }
}
