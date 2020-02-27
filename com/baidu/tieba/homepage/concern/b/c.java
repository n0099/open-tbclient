package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes9.dex */
public class c implements m {
    public static final BdUniqueId gYf = BdUniqueId.gen();
    public static final BdUniqueId gYg = BdUniqueId.gen();
    public int gYh;
    public boolean gYi;
    public boolean gYj;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.gYh) {
            case 2:
            case 3:
                return gYg;
            default:
                return gYf;
        }
    }
}
