package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId fXV = BdUniqueId.gen();
    public static final BdUniqueId fXW = BdUniqueId.gen();
    public String bWk;
    public int fXX;
    public boolean fXY;
    public boolean fXZ;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.fXX) {
            case 2:
            case 3:
                return fXW;
            default:
                return fXV;
        }
    }
}
