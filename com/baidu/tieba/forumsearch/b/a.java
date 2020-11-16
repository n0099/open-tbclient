package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId iGh = BdUniqueId.gen();
    public static final BdUniqueId iGi = BdUniqueId.gen();
    public static final BdUniqueId iGj = BdUniqueId.gen();
    private BdUniqueId Vx;
    private ArrayList<String> iGk;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vx;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Vx = bdUniqueId;
    }

    public a() {
        this.Vx = iGi;
        this.Vx = iGi;
    }

    public a(ArrayList<String> arrayList) {
        this.Vx = iGi;
        this.iGk = arrayList;
        this.Vx = iGh;
    }

    public ArrayList<String> cwA() {
        return this.iGk;
    }
}
