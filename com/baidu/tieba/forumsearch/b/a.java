package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.data.b {
    private BdUniqueId TK;
    private ArrayList<String> hlC;
    public static final BdUniqueId hlz = BdUniqueId.gen();
    public static final BdUniqueId hlA = BdUniqueId.gen();
    public static final BdUniqueId hlB = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return this.TK;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.TK = bdUniqueId;
    }

    public a() {
        this.TK = hlA;
        this.TK = hlA;
    }

    public a(ArrayList<String> arrayList) {
        this.TK = hlA;
        this.hlC = arrayList;
        this.TK = hlz;
    }

    public ArrayList<String> bTQ() {
        return this.hlC;
    }
}
