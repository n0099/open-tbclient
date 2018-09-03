package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class a implements h {
    public static final BdUniqueId dTw = BdUniqueId.gen();
    public static final BdUniqueId dTx = BdUniqueId.gen();
    public String ats;
    public boolean dTA;
    public int dTy;
    public boolean dTz;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.dTy) {
            case 2:
            case 3:
                return dTx;
            default:
                return dTw;
        }
    }
}
