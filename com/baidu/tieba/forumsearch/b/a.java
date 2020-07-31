package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hDF = BdUniqueId.gen();
    public static final BdUniqueId hDG = BdUniqueId.gen();
    public static final BdUniqueId hDH = BdUniqueId.gen();
    private BdUniqueId Uh;
    private ArrayList<String> hDI;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Uh;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Uh = bdUniqueId;
    }

    public a() {
        this.Uh = hDG;
        this.Uh = hDG;
    }

    public a(ArrayList<String> arrayList) {
        this.Uh = hDG;
        this.hDI = arrayList;
        this.Uh = hDF;
    }

    public ArrayList<String> cai() {
        return this.hDI;
    }
}
