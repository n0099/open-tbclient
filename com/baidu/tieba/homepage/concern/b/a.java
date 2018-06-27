package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class a implements h {
    public static final BdUniqueId dQO = BdUniqueId.gen();
    public static final BdUniqueId dQP = BdUniqueId.gen();
    public String atN;
    public int dQQ;
    public boolean dQR;
    public boolean dQS;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.dQQ) {
            case 2:
            case 3:
                return dQP;
            default:
                return dQO;
        }
    }
}
