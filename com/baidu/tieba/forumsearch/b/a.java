package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dii = BdUniqueId.gen();
    public static final BdUniqueId dij = BdUniqueId.gen();
    public static final BdUniqueId dik = BdUniqueId.gen();
    private ArrayList<String> dil;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dij;
        this.mType = dij;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dij;
        this.dil = arrayList;
        this.mType = dii;
    }

    public ArrayList<String> asT() {
        return this.dil;
    }
}
