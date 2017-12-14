package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class a implements f {
    public String ajH;
    public int doB;
    public boolean doC;
    public boolean doD;
    public static final BdUniqueId doz = BdUniqueId.gen();
    public static final BdUniqueId doA = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        switch (this.doB) {
            case 2:
            case 3:
                return doA;
            default:
                return doz;
        }
    }
}
