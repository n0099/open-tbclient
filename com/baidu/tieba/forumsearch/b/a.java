package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fno = BdUniqueId.gen();
    public static final BdUniqueId fnp = BdUniqueId.gen();
    public static final BdUniqueId fnq = BdUniqueId.gen();
    private ArrayList<String> fnr;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = fnp;
        this.mType = fnp;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = fnp;
        this.fnr = arrayList;
        this.mType = fno;
    }

    public ArrayList<String> biQ() {
        return this.fnr;
    }
}
