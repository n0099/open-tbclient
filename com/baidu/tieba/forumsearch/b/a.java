package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fsV = BdUniqueId.gen();
    public static final BdUniqueId fsW = BdUniqueId.gen();
    public static final BdUniqueId fsX = BdUniqueId.gen();
    private ArrayList<String> fsY;
    private BdUniqueId xl;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.xl;
    }

    public void n(BdUniqueId bdUniqueId) {
        this.xl = bdUniqueId;
    }

    public a() {
        this.xl = fsW;
        this.xl = fsW;
    }

    public a(ArrayList<String> arrayList) {
        this.xl = fsW;
        this.fsY = arrayList;
        this.xl = fsV;
    }

    public ArrayList<String> biO() {
        return this.fsY;
    }
}
