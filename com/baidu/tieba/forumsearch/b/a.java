package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gmE = BdUniqueId.gen();
    public static final BdUniqueId gmF = BdUniqueId.gen();
    public static final BdUniqueId gmG = BdUniqueId.gen();
    private BdUniqueId Ag;
    private ArrayList<String> gmH;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Ag;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.Ag = bdUniqueId;
    }

    public a() {
        this.Ag = gmF;
        this.Ag = gmF;
    }

    public a(ArrayList<String> arrayList) {
        this.Ag = gmF;
        this.gmH = arrayList;
        this.Ag = gmE;
    }

    public ArrayList<String> bCN() {
        return this.gmH;
    }
}
