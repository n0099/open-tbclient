package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId kbL = BdUniqueId.gen();
    public static final BdUniqueId kbM = BdUniqueId.gen();
    public int kbN;
    public boolean kbO;
    public boolean kbP;
    public BdUniqueId kbQ = kbM;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.kbQ;
    }
}
