package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId gef = BdUniqueId.gen();
    public static final BdUniqueId geg = BdUniqueId.gen();
    public int geh;
    public boolean gei;
    public boolean gej;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.geh) {
            case 2:
            case 3:
                return geg;
            default:
                return gef;
        }
    }
}
