package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cXe = BdUniqueId.gen();
    public static final BdUniqueId cXf = BdUniqueId.gen();
    public static final BdUniqueId cXg = BdUniqueId.gen();
    private ArrayList<String> cXh;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = cXf;
        this.mType = cXf;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = cXf;
        this.cXh = arrayList;
        this.mType = cXe;
    }

    public ArrayList<String> aoD() {
        return this.cXh;
    }
}
