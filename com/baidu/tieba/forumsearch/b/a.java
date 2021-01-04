package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId jdn = BdUniqueId.gen();
    public static final BdUniqueId jdo = BdUniqueId.gen();
    public static final BdUniqueId jdp = BdUniqueId.gen();
    private BdUniqueId Ws;
    private ArrayList<String> jdq;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Ws;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Ws = bdUniqueId;
    }

    public a() {
        this.Ws = jdo;
        this.Ws = jdo;
    }

    public a(ArrayList<String> arrayList) {
        this.Ws = jdo;
        this.jdq = arrayList;
        this.Ws = jdn;
    }

    public ArrayList<String> cDJ() {
        return this.jdq;
    }
}
