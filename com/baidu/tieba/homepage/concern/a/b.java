package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes21.dex */
public class b implements q {
    public static final BdUniqueId jxJ = BdUniqueId.gen();
    public static final BdUniqueId jxK = BdUniqueId.gen();
    public int jxL;
    public boolean jxM;
    public boolean jxN;
    public BdUniqueId jxO = jxK;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.jxO;
    }
}
