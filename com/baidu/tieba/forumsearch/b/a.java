package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dDo = BdUniqueId.gen();
    public static final BdUniqueId dDp = BdUniqueId.gen();
    public static final BdUniqueId dDq = BdUniqueId.gen();
    private ArrayList<String> dDr;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dDp;
        this.mType = dDp;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dDp;
        this.dDr = arrayList;
        this.mType = dDo;
    }

    public ArrayList<String> aup() {
        return this.dDr;
    }
}
