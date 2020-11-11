package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iFt = BdUniqueId.gen();
    public static final BdUniqueId iFu = BdUniqueId.gen();
    public static final BdUniqueId iFv = BdUniqueId.gen();
    private BdUniqueId Vw;
    private ArrayList<String> iFw;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vw;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Vw = bdUniqueId;
    }

    public a() {
        this.Vw = iFu;
        this.Vw = iFu;
    }

    public a(ArrayList<String> arrayList) {
        this.Vw = iFu;
        this.iFw = arrayList;
        this.Vw = iFt;
    }

    public ArrayList<String> cwY() {
        return this.iFw;
    }
}
