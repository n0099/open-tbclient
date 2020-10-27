package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId izw = BdUniqueId.gen();
    public static final BdUniqueId izx = BdUniqueId.gen();
    public static final BdUniqueId izy = BdUniqueId.gen();
    private BdUniqueId Vw;
    private ArrayList<String> izz;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vw;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Vw = bdUniqueId;
    }

    public a() {
        this.Vw = izx;
        this.Vw = izx;
    }

    public a(ArrayList<String> arrayList) {
        this.Vw = izx;
        this.izz = arrayList;
        this.Vw = izw;
    }

    public ArrayList<String> cux() {
        return this.izz;
    }
}
