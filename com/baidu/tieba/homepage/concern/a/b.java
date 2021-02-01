package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId kbx = BdUniqueId.gen();
    public static final BdUniqueId kby = BdUniqueId.gen();
    public boolean kbA;
    public boolean kbB;
    public BdUniqueId kbC = kby;
    public int kbz;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.kbC;
    }
}
