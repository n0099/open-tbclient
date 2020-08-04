package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes16.dex */
public class c implements q {
    public static final BdUniqueId itt = BdUniqueId.gen();
    public static final BdUniqueId itu = BdUniqueId.gen();
    public int itv;
    public boolean itw;
    public boolean itx;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.itv) {
            case 2:
            case 3:
                return itu;
            default:
                return itt;
        }
    }
}
