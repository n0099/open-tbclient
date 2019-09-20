package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId gfA = BdUniqueId.gen();
    public static final BdUniqueId gfB = BdUniqueId.gen();
    public String bYl;
    public int gfC;
    public boolean gfD;
    public boolean gfE;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.gfC) {
            case 2:
            case 3:
                return gfB;
            default:
                return gfA;
        }
    }
}
