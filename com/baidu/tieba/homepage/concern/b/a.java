package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class a implements h {
    public static final BdUniqueId dBj = BdUniqueId.gen();
    public static final BdUniqueId dBk = BdUniqueId.gen();
    public String alc;
    public int dBl;
    public boolean dBm;
    public boolean dBn;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.dBl) {
            case 2:
            case 3:
                return dBk;
            default:
                return dBj;
        }
    }
}
