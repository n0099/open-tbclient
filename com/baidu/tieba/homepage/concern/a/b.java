package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId jTW = BdUniqueId.gen();
    public static final BdUniqueId jTX = BdUniqueId.gen();
    public int jTY;
    public boolean jTZ;
    public boolean jUa;
    public BdUniqueId jUb = jTX;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.jUb;
    }
}
