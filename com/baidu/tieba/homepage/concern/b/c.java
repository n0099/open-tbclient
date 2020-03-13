package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes9.dex */
public class c implements m {
    public static final BdUniqueId gYt = BdUniqueId.gen();
    public static final BdUniqueId gYu = BdUniqueId.gen();
    public int gYv;
    public boolean gYw;
    public boolean gYx;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.gYv) {
            case 2:
            case 3:
                return gYu;
            default:
                return gYt;
        }
    }
}
