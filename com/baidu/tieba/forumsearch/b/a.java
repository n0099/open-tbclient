package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eXg = BdUniqueId.gen();
    public static final BdUniqueId eXh = BdUniqueId.gen();
    public static final BdUniqueId eXi = BdUniqueId.gen();
    private ArrayList<String> eXj;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = eXh;
        this.mType = eXh;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = eXh;
        this.eXj = arrayList;
        this.mType = eXg;
    }

    public ArrayList<String> bbx() {
        return this.eXj;
    }
}
