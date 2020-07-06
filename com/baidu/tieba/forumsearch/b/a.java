package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hxR = BdUniqueId.gen();
    public static final BdUniqueId hxS = BdUniqueId.gen();
    public static final BdUniqueId hxT = BdUniqueId.gen();
    private BdUniqueId Un;
    private ArrayList<String> hxU;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Un;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Un = bdUniqueId;
    }

    public a() {
        this.Un = hxS;
        this.Un = hxS;
    }

    public a(ArrayList<String> arrayList) {
        this.Un = hxS;
        this.hxU = arrayList;
        this.Un = hxR;
    }

    public ArrayList<String> bWP() {
        return this.hxU;
    }
}
