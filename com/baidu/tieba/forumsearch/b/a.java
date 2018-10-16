package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dyQ = BdUniqueId.gen();
    public static final BdUniqueId dyR = BdUniqueId.gen();
    public static final BdUniqueId dyS = BdUniqueId.gen();
    private ArrayList<String> dyT;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dyR;
        this.mType = dyR;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dyR;
        this.dyT = arrayList;
        this.mType = dyQ;
    }

    public ArrayList<String> ayG() {
        return this.dyT;
    }
}
