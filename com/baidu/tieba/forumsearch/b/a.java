package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId iQZ = BdUniqueId.gen();
    public static final BdUniqueId iRa = BdUniqueId.gen();
    public static final BdUniqueId iRb = BdUniqueId.gen();
    private BdUniqueId Wv;
    private ArrayList<String> iRc;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Wv;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Wv = bdUniqueId;
    }

    public a() {
        this.Wv = iRa;
        this.Wv = iRa;
    }

    public a(ArrayList<String> arrayList) {
        this.Wv = iRa;
        this.iRc = arrayList;
        this.Wv = iQZ;
    }

    public ArrayList<String> cAP() {
        return this.iRc;
    }
}
