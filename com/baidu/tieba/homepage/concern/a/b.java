package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId jYB = BdUniqueId.gen();
    public static final BdUniqueId jYC = BdUniqueId.gen();
    public int jYD;
    public boolean jYE;
    public boolean jYF;
    public BdUniqueId jYG = jYC;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.jYG;
    }
}
