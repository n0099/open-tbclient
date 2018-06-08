package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dgr = BdUniqueId.gen();
    public static final BdUniqueId dgs = BdUniqueId.gen();
    public static final BdUniqueId dgt = BdUniqueId.gen();
    private ArrayList<String> dgu;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dgs;
        this.mType = dgs;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dgs;
        this.dgu = arrayList;
        this.mType = dgr;
    }

    public ArrayList<String> asI() {
        return this.dgu;
    }
}
