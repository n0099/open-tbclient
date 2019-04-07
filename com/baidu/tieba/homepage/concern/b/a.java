package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId fGH = BdUniqueId.gen();
    public static final BdUniqueId fGI = BdUniqueId.gen();
    public String bOu;
    public int fGJ;
    public boolean fGK;
    public boolean fGL;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.fGJ) {
            case 2:
            case 3:
                return fGI;
            default:
                return fGH;
        }
    }
}
