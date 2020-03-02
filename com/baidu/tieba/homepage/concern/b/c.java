package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes9.dex */
public class c implements m {
    public static final BdUniqueId gYh = BdUniqueId.gen();
    public static final BdUniqueId gYi = BdUniqueId.gen();
    public int gYj;
    public boolean gYk;
    public boolean gYl;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.gYj) {
            case 2:
            case 3:
                return gYi;
            default:
                return gYh;
        }
    }
}
