package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.b {
    private ArrayList<String> fuC;
    private BdUniqueId mType;
    public static final BdUniqueId fuz = BdUniqueId.gen();
    public static final BdUniqueId fuA = BdUniqueId.gen();
    public static final BdUniqueId fuB = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = fuA;
        this.mType = fuA;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = fuA;
        this.fuC = arrayList;
        this.mType = fuz;
    }

    public ArrayList<String> blK() {
        return this.fuC;
    }
}
