package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dKe = BdUniqueId.gen();
    public static final BdUniqueId dKf = BdUniqueId.gen();
    public static final BdUniqueId dKg = BdUniqueId.gen();
    private ArrayList<String> dKh;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dKf;
        this.mType = dKf;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dKf;
        this.dKh = arrayList;
        this.mType = dKe;
    }

    public ArrayList<String> aBa() {
        return this.dKh;
    }
}
