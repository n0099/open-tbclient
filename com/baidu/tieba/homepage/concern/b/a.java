package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class a implements f {
    public static final BdUniqueId doD = BdUniqueId.gen();
    public static final BdUniqueId doE = BdUniqueId.gen();
    public String ajK;
    public int doF;
    public boolean doG;
    public boolean doH;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        switch (this.doF) {
            case 2:
            case 3:
                return doE;
            default:
                return doD;
        }
    }
}
