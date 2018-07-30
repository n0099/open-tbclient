package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dkY = BdUniqueId.gen();
    public static final BdUniqueId dkZ = BdUniqueId.gen();
    public static final BdUniqueId dla = BdUniqueId.gen();
    private ArrayList<String> dlb;
    private BdUniqueId mType;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    public a() {
        this.mType = dkZ;
        this.mType = dkZ;
    }

    public a(ArrayList<String> arrayList) {
        this.mType = dkZ;
        this.dlb = arrayList;
        this.mType = dkY;
    }

    public ArrayList<String> atx() {
        return this.dlb;
    }
}
