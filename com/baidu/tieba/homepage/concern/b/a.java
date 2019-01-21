package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes6.dex */
public class a implements h {
    public static final BdUniqueId euw = BdUniqueId.gen();
    public static final BdUniqueId eux = BdUniqueId.gen();
    public String aGk;
    public boolean euA;
    public int euy;
    public boolean euz;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.euy) {
            case 2:
            case 3:
                return eux;
            default:
                return euw;
        }
    }
}
