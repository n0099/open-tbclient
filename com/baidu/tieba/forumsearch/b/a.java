package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eXu = BdUniqueId.gen();
    public static final BdUniqueId eXv = BdUniqueId.gen();
    public static final BdUniqueId eXw = BdUniqueId.gen();
    private ArrayList<String> eXx;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = eXv;
        this.mType = eXv;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = eXv;
        this.eXx = arrayList;
        this.mType = eXu;
    }

    public ArrayList<String> bbz() {
        return this.eXx;
    }
}
