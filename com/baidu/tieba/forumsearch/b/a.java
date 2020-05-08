package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gWN = BdUniqueId.gen();
    public static final BdUniqueId gWO = BdUniqueId.gen();
    public static final BdUniqueId gWP = BdUniqueId.gen();
    private BdUniqueId Ty;
    private ArrayList<String> gWQ;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Ty;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.Ty = bdUniqueId;
    }

    public a() {
        this.Ty = gWO;
        this.Ty = gWO;
    }

    public a(ArrayList<String> arrayList) {
        this.Ty = gWO;
        this.gWQ = arrayList;
        this.Ty = gWN;
    }

    public ArrayList<String> bNu() {
        return this.gWQ;
    }
}
