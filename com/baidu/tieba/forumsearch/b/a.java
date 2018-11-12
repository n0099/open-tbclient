package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dAh = BdUniqueId.gen();
    public static final BdUniqueId dAi = BdUniqueId.gen();
    public static final BdUniqueId dAj = BdUniqueId.gen();
    private ArrayList<String> dAk;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dAi;
        this.mType = dAi;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dAi;
        this.dAk = arrayList;
        this.mType = dAh;
    }

    public ArrayList<String> aye() {
        return this.dAk;
    }
}
