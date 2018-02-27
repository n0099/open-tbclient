package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dDc = BdUniqueId.gen();
    public static final BdUniqueId dDd = BdUniqueId.gen();
    public static final BdUniqueId dDe = BdUniqueId.gen();
    private ArrayList<String> dDf;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dDd;
        this.mType = dDd;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dDd;
        this.dDf = arrayList;
        this.mType = dDc;
    }

    public ArrayList<String> auo() {
        return this.dDf;
    }
}
