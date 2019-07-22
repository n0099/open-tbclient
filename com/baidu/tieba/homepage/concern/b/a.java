package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class a implements m {
    public static final BdUniqueId gcS = BdUniqueId.gen();
    public static final BdUniqueId gcT = BdUniqueId.gen();
    public String bXm;
    public int gcU;
    public boolean gcV;
    public boolean gcW;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.gcU) {
            case 2:
            case 3:
                return gcT;
            default:
                return gcS;
        }
    }
}
