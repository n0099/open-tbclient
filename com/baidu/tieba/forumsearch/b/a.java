package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fsn = BdUniqueId.gen();
    public static final BdUniqueId fso = BdUniqueId.gen();
    public static final BdUniqueId fsp = BdUniqueId.gen();
    private ArrayList<String> fsq;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = fso;
        this.mType = fso;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = fso;
        this.fsq = arrayList;
        this.mType = fsn;
    }

    public ArrayList<String> bkS() {
        return this.fsq;
    }
}
