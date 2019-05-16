package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId fXS = BdUniqueId.gen();
    public static final BdUniqueId fXT = BdUniqueId.gen();
    public String bWj;
    public int fXU;
    public boolean fXV;
    public boolean fXW;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.fXU) {
            case 2:
            case 3:
                return fXT;
            default:
                return fXS;
        }
    }
}
