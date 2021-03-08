package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId kdN = BdUniqueId.gen();
    public static final BdUniqueId kdO = BdUniqueId.gen();
    public int kdP;
    public boolean kdQ;
    public boolean kdR;
    public BdUniqueId kdS = kdO;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.kdS;
    }
}
