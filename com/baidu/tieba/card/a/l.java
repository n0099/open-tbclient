package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a.a {
    public static final BdUniqueId TC = BdUniqueId.gen();
    private List<a> aTc = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int aVN;
        public long id;
        public String link;
        public int position;
        public String title;
        public int type;
        public String url;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return TC;
    }

    public List<a> FZ() {
        return this.aTc;
    }
}
