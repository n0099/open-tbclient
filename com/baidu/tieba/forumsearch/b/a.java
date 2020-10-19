package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId imZ = BdUniqueId.gen();
    public static final BdUniqueId ina = BdUniqueId.gen();
    public static final BdUniqueId inb = BdUniqueId.gen();
    private BdUniqueId Vv;
    private ArrayList<String> inc;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vv;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Vv = bdUniqueId;
    }

    public a() {
        this.Vv = ina;
        this.Vv = ina;
    }

    public a(ArrayList<String> arrayList) {
        this.Vv = ina;
        this.inc = arrayList;
        this.Vv = imZ;
    }

    public ArrayList<String> crq() {
        return this.inc;
    }
}
