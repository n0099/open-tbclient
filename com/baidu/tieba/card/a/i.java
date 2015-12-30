package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.a.a {
    public static final BdUniqueId aPP = BdUniqueId.gen();
    private final List<a> aOe = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public long id;
        public String link;
        public int position;
        public String title;
        public String url;
    }

    public void a(a aVar) {
        this.aOe.add(aVar);
    }

    public List<a> DS() {
        return this.aOe;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aPP;
    }
}
