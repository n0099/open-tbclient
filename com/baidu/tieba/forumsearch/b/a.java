package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hQT = BdUniqueId.gen();
    public static final BdUniqueId hQU = BdUniqueId.gen();
    public static final BdUniqueId hQV = BdUniqueId.gen();
    private BdUniqueId UM;
    private ArrayList<String> hQW;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.UM;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.UM = bdUniqueId;
    }

    public a() {
        this.UM = hQU;
        this.UM = hQU;
    }

    public a(ArrayList<String> arrayList) {
        this.UM = hQU;
        this.hQW = arrayList;
        this.UM = hQT;
    }

    public ArrayList<String> ckE() {
        return this.hQW;
    }
}
