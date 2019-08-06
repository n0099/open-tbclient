package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fsM = BdUniqueId.gen();
    public static final BdUniqueId fsN = BdUniqueId.gen();
    public static final BdUniqueId fsO = BdUniqueId.gen();
    private ArrayList<String> fsP;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = fsN;
        this.mType = fsN;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = fsN;
        this.fsP = arrayList;
        this.mType = fsM;
    }

    public ArrayList<String> bkZ() {
        return this.fsP;
    }
}
