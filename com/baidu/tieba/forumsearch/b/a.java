package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dkW = BdUniqueId.gen();
    public static final BdUniqueId dkX = BdUniqueId.gen();
    public static final BdUniqueId dkY = BdUniqueId.gen();
    private ArrayList<String> dkZ;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dkX;
        this.mType = dkX;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dkX;
        this.dkZ = arrayList;
        this.mType = dkW;
    }

    public ArrayList<String> atw() {
        return this.dkZ;
    }
}
