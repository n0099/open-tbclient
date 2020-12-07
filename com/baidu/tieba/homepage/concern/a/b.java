package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class b implements q {
    public static final BdUniqueId jLl = BdUniqueId.gen();
    public static final BdUniqueId jLm = BdUniqueId.gen();
    public int jLn;
    public boolean jLo;
    public boolean jLp;
    public BdUniqueId jLq = jLm;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.jLq;
    }
}
