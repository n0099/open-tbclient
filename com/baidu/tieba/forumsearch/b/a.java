package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gkD = BdUniqueId.gen();
    public static final BdUniqueId gkE = BdUniqueId.gen();
    public static final BdUniqueId gkF = BdUniqueId.gen();
    private ArrayList<String> gkG;
    private BdUniqueId zN;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.zN;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.zN = bdUniqueId;
    }

    public a() {
        this.zN = gkE;
        this.zN = gkE;
    }

    public a(ArrayList<String> arrayList) {
        this.zN = gkE;
        this.gkG = arrayList;
        this.zN = gkD;
    }

    public ArrayList<String> bBl() {
        return this.gkG;
    }
}
