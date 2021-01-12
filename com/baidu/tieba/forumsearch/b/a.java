package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId iYG = BdUniqueId.gen();
    public static final BdUniqueId iYH = BdUniqueId.gen();
    public static final BdUniqueId iYI = BdUniqueId.gen();
    private BdUniqueId Wq;
    private ArrayList<String> iYJ;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Wq;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Wq = bdUniqueId;
    }

    public a() {
        this.Wq = iYH;
        this.Wq = iYH;
    }

    public a(ArrayList<String> arrayList) {
        this.Wq = iYH;
        this.iYJ = arrayList;
        this.Wq = iYG;
    }

    public ArrayList<String> czS() {
        return this.iYJ;
    }
}
