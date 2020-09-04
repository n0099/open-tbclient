package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hQZ = BdUniqueId.gen();
    public static final BdUniqueId hRa = BdUniqueId.gen();
    public static final BdUniqueId hRb = BdUniqueId.gen();
    private BdUniqueId UM;
    private ArrayList<String> hRc;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.UM;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.UM = bdUniqueId;
    }

    public a() {
        this.UM = hRa;
        this.UM = hRa;
    }

    public a(ArrayList<String> arrayList) {
        this.UM = hRa;
        this.hRc = arrayList;
        this.UM = hQZ;
    }

    public ArrayList<String> ckF() {
        return this.hRc;
    }
}
