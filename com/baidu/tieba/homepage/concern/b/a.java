package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes6.dex */
public class a implements h {
    public static final BdUniqueId etP = BdUniqueId.gen();
    public static final BdUniqueId etQ = BdUniqueId.gen();
    public String aFH;
    public int etR;
    public boolean etS;
    public boolean etT;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.etR) {
            case 2:
            case 3:
                return etQ;
            default:
                return etP;
        }
    }
}
