package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hXZ = BdUniqueId.gen();
    public static final BdUniqueId hYa = BdUniqueId.gen();
    public static final BdUniqueId hYb = BdUniqueId.gen();
    private BdUniqueId Vf;
    private ArrayList<String> hYc;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vf;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Vf = bdUniqueId;
    }

    public a() {
        this.Vf = hYa;
        this.Vf = hYa;
    }

    public a(ArrayList<String> arrayList) {
        this.Vf = hYa;
        this.hYc = arrayList;
        this.Vf = hXZ;
    }

    public ArrayList<String> cnS() {
        return this.hYc;
    }
}
