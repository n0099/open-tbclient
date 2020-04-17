package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gWH = BdUniqueId.gen();
    public static final BdUniqueId gWI = BdUniqueId.gen();
    public static final BdUniqueId gWJ = BdUniqueId.gen();
    private BdUniqueId Tv;
    private ArrayList<String> gWK;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Tv;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.Tv = bdUniqueId;
    }

    public a() {
        this.Tv = gWI;
        this.Tv = gWI;
    }

    public a(ArrayList<String> arrayList) {
        this.Tv = gWI;
        this.gWK = arrayList;
        this.Tv = gWH;
    }

    public ArrayList<String> bNw() {
        return this.gWK;
    }
}
