package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId geX = BdUniqueId.gen();
    public static final BdUniqueId geY = BdUniqueId.gen();
    public int geZ;
    public boolean gfa;
    public boolean gfb;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.geZ) {
            case 2:
            case 3:
                return geY;
            default:
                return geX;
        }
    }
}
