package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId iRb = BdUniqueId.gen();
    public static final BdUniqueId iRc = BdUniqueId.gen();
    public static final BdUniqueId iRd = BdUniqueId.gen();
    private BdUniqueId Wv;
    private ArrayList<String> iRe;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Wv;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Wv = bdUniqueId;
    }

    public a() {
        this.Wv = iRc;
        this.Wv = iRc;
    }

    public a(ArrayList<String> arrayList) {
        this.Wv = iRc;
        this.iRe = arrayList;
        this.Wv = iRb;
    }

    public ArrayList<String> cAQ() {
        return this.iRe;
    }
}
