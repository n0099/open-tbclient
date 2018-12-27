package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dJu = BdUniqueId.gen();
    public static final BdUniqueId dJv = BdUniqueId.gen();
    public static final BdUniqueId dJw = BdUniqueId.gen();
    private ArrayList<String> dJx;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dJv;
        this.mType = dJv;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dJv;
        this.dJx = arrayList;
        this.mType = dJu;
    }

    public ArrayList<String> aAD() {
        return this.dJx;
    }
}
