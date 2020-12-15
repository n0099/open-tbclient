package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class b implements q {
    public static final BdUniqueId jLn = BdUniqueId.gen();
    public static final BdUniqueId jLo = BdUniqueId.gen();
    public int jLp;
    public boolean jLq;
    public boolean jLr;
    public BdUniqueId jLs = jLo;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.jLs;
    }
}
