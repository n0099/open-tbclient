package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cVX = BdUniqueId.gen();
    public static final BdUniqueId cVY = BdUniqueId.gen();
    public static final BdUniqueId cVZ = BdUniqueId.gen();
    private ArrayList<String> cWa;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = cVY;
        this.mType = cVY;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = cVY;
        this.cWa = arrayList;
        this.mType = cVX;
    }

    public ArrayList<String> aoE() {
        return this.cWa;
    }
}
