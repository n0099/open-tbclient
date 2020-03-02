package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gmG = BdUniqueId.gen();
    public static final BdUniqueId gmH = BdUniqueId.gen();
    public static final BdUniqueId gmI = BdUniqueId.gen();
    private BdUniqueId Ag;
    private ArrayList<String> gmJ;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Ag;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.Ag = bdUniqueId;
    }

    public a() {
        this.Ag = gmH;
        this.Ag = gmH;
    }

    public a(ArrayList<String> arrayList) {
        this.Ag = gmH;
        this.gmJ = arrayList;
        this.Ag = gmG;
    }

    public ArrayList<String> bCP() {
        return this.gmJ;
    }
}
