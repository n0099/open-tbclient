package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId fXT = BdUniqueId.gen();
    public static final BdUniqueId fXU = BdUniqueId.gen();
    public String bWj;
    public int fXV;
    public boolean fXW;
    public boolean fXX;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.fXV) {
            case 2:
            case 3:
                return fXU;
            default:
                return fXT;
        }
    }
}
