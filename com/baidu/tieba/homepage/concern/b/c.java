package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes9.dex */
public class c implements m {
    public static final BdUniqueId hJq = BdUniqueId.gen();
    public static final BdUniqueId hJr = BdUniqueId.gen();
    public int hJs;
    public boolean hJt;
    public boolean hJu;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.hJs) {
            case 2:
            case 3:
                return hJr;
            default:
                return hJq;
        }
    }
}
