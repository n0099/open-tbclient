package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ftM = BdUniqueId.gen();
    public static final BdUniqueId ftN = BdUniqueId.gen();
    public static final BdUniqueId ftO = BdUniqueId.gen();
    private ArrayList<String> ftP;
    private BdUniqueId xL;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.xL;
    }

    public void n(BdUniqueId bdUniqueId) {
        this.xL = bdUniqueId;
    }

    public a() {
        this.xL = ftN;
        this.xL = ftN;
    }

    public a(ArrayList<String> arrayList) {
        this.xL = ftN;
        this.ftP = arrayList;
        this.xL = ftM;
    }

    public ArrayList<String> biQ() {
        return this.ftP;
    }
}
