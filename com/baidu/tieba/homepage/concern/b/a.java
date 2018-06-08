package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class a implements h {
    public static final BdUniqueId dNw = BdUniqueId.gen();
    public static final BdUniqueId dNx = BdUniqueId.gen();
    public String atk;
    public boolean dNA;
    public int dNy;
    public boolean dNz;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.dNy) {
            case 2:
            case 3:
                return dNx;
            default:
                return dNw;
        }
    }
}
