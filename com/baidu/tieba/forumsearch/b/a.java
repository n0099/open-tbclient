package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId jen = BdUniqueId.gen();
    public static final BdUniqueId jeo = BdUniqueId.gen();
    public static final BdUniqueId jep = BdUniqueId.gen();
    private BdUniqueId Wm;
    private ArrayList<String> jeq;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Wm;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.Wm = bdUniqueId;
    }

    public a() {
        this.Wm = jeo;
        this.Wm = jeo;
    }

    public a(ArrayList<String> arrayList) {
        this.Wm = jeo;
        this.jeq = arrayList;
        this.Wm = jen;
    }

    public ArrayList<String> cBd() {
        return this.jeq;
    }
}
