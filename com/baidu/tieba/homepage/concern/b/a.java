package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId fGT = BdUniqueId.gen();
    public static final BdUniqueId fGU = BdUniqueId.gen();
    public String bOs;
    public int fGV;
    public boolean fGW;
    public boolean fGX;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.fGV) {
            case 2:
            case 3:
                return fGU;
            default:
                return fGT;
        }
    }
}
