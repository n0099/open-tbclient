package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dqP = BdUniqueId.gen();
    public static final BdUniqueId dqQ = BdUniqueId.gen();
    public static final BdUniqueId dqR = BdUniqueId.gen();
    private ArrayList<String> dqS;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dqQ;
        this.mType = dqQ;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dqQ;
        this.dqS = arrayList;
        this.mType = dqP;
    }

    public ArrayList<String> avk() {
        return this.dqS;
    }
}
