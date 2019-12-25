package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ght = BdUniqueId.gen();
    public static final BdUniqueId ghu = BdUniqueId.gen();
    public static final BdUniqueId ghv = BdUniqueId.gen();
    private ArrayList<String> ghw;
    private BdUniqueId zJ;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.zJ;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.zJ = bdUniqueId;
    }

    public a() {
        this.zJ = ghu;
        this.zJ = ghu;
    }

    public a(ArrayList<String> arrayList) {
        this.zJ = ghu;
        this.ghw = arrayList;
        this.zJ = ght;
    }

    public ArrayList<String> bAj() {
        return this.ghw;
    }
}
