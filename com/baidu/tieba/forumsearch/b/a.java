package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gmT = BdUniqueId.gen();
    public static final BdUniqueId gmU = BdUniqueId.gen();
    public static final BdUniqueId gmV = BdUniqueId.gen();
    private BdUniqueId Ag;
    private ArrayList<String> gmW;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Ag;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.Ag = bdUniqueId;
    }

    public a() {
        this.Ag = gmU;
        this.Ag = gmU;
    }

    public a(ArrayList<String> arrayList) {
        this.Ag = gmU;
        this.gmW = arrayList;
        this.Ag = gmT;
    }

    public ArrayList<String> bCQ() {
        return this.gmW;
    }
}
