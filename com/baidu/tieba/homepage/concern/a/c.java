package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class c implements q {
    public static final BdUniqueId jey = BdUniqueId.gen();
    public static final BdUniqueId jez = BdUniqueId.gen();
    public int jeA;
    public boolean jeB;
    public boolean jeC;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.jeA) {
            case 2:
            case 3:
                return jez;
            default:
                return jey;
        }
    }
}
