package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gnB = BdUniqueId.gen();
    public static final BdUniqueId gnC = BdUniqueId.gen();
    public static final BdUniqueId gnD = BdUniqueId.gen();
    private BdUniqueId Ag;
    private ArrayList<String> gnE;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Ag;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.Ag = bdUniqueId;
    }

    public a() {
        this.Ag = gnC;
        this.Ag = gnC;
    }

    public a(ArrayList<String> arrayList) {
        this.Ag = gnC;
        this.gnE = arrayList;
        this.Ag = gnB;
    }

    public ArrayList<String> bCW() {
        return this.gnE;
    }
}
