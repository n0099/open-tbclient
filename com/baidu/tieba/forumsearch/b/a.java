package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId jgk = BdUniqueId.gen();
    public static final BdUniqueId jgl = BdUniqueId.gen();
    public static final BdUniqueId jgm = BdUniqueId.gen();
    private BdUniqueId XG;
    private ArrayList<String> jgn;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.XG;
    }

    public void g(BdUniqueId bdUniqueId) {
        this.XG = bdUniqueId;
    }

    public a() {
        this.XG = jgl;
        this.XG = jgl;
    }

    public a(ArrayList<String> arrayList) {
        this.XG = jgl;
        this.jgn = arrayList;
        this.XG = jgk;
    }

    public ArrayList<String> cBq() {
        return this.jgn;
    }
}
