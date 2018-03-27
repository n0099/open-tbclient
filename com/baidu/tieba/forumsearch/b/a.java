package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dDf = BdUniqueId.gen();
    public static final BdUniqueId dDg = BdUniqueId.gen();
    public static final BdUniqueId dDh = BdUniqueId.gen();
    private ArrayList<String> dDi;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dDg;
        this.mType = dDg;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dDg;
        this.dDi = arrayList;
        this.mType = dDf;
    }

    public ArrayList<String> aup() {
        return this.dDi;
    }
}
