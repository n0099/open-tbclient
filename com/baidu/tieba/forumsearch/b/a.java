package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId jeB = BdUniqueId.gen();
    public static final BdUniqueId jeC = BdUniqueId.gen();
    public static final BdUniqueId jeD = BdUniqueId.gen();
    private BdUniqueId Wm;
    private ArrayList<String> jeE;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Wm;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Wm = bdUniqueId;
    }

    public a() {
        this.Wm = jeC;
        this.Wm = jeC;
    }

    public a(ArrayList<String> arrayList) {
        this.Wm = jeC;
        this.jeE = arrayList;
        this.Wm = jeB;
    }

    public ArrayList<String> cBk() {
        return this.jeE;
    }
}
