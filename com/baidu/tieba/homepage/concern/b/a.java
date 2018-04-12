package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class a implements h {
    public static final BdUniqueId dBm = BdUniqueId.gen();
    public static final BdUniqueId dBn = BdUniqueId.gen();
    public String alc;
    public int dBo;
    public boolean dBp;
    public boolean dBq;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.dBo) {
            case 2:
            case 3:
                return dBn;
            default:
                return dBm;
        }
    }
}
