package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hlK = BdUniqueId.gen();
    public static final BdUniqueId hlL = BdUniqueId.gen();
    public static final BdUniqueId hlM = BdUniqueId.gen();
    private BdUniqueId TK;
    private ArrayList<String> hlN;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return this.TK;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.TK = bdUniqueId;
    }

    public a() {
        this.TK = hlL;
        this.TK = hlL;
    }

    public a(ArrayList<String> arrayList) {
        this.TK = hlL;
        this.hlN = arrayList;
        this.TK = hlK;
    }

    public ArrayList<String> bTS() {
        return this.hlN;
    }
}
