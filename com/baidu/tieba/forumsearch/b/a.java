package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dGG = BdUniqueId.gen();
    public static final BdUniqueId dGH = BdUniqueId.gen();
    public static final BdUniqueId dGI = BdUniqueId.gen();
    private ArrayList<String> dGJ;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dGH;
        this.mType = dGH;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dGH;
        this.dGJ = arrayList;
        this.mType = dGG;
    }

    public ArrayList<String> azO() {
        return this.dGJ;
    }
}
