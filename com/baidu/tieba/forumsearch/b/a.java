package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fnn = BdUniqueId.gen();
    public static final BdUniqueId fno = BdUniqueId.gen();
    public static final BdUniqueId fnp = BdUniqueId.gen();
    private ArrayList<String> fnq;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = fno;
        this.mType = fno;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = fno;
        this.fnq = arrayList;
        this.mType = fnn;
    }

    public ArrayList<String> biN() {
        return this.fnq;
    }
}
