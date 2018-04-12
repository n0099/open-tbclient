package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cWa = BdUniqueId.gen();
    public static final BdUniqueId cWb = BdUniqueId.gen();
    public static final BdUniqueId cWc = BdUniqueId.gen();
    private ArrayList<String> cWd;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = cWb;
        this.mType = cWb;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = cWb;
        this.cWd = arrayList;
        this.mType = cWa;
    }

    public ArrayList<String> aoE() {
        return this.cWd;
    }
}
