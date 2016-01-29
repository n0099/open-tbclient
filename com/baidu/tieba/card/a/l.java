package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a.a {
    public static final BdUniqueId aRS = BdUniqueId.gen();
    private final List<a> aQh = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public long id;
        public String link;
        public int position;
        public String title;
        public String url;
    }

    public void a(a aVar) {
        this.aQh.add(aVar);
    }

    public List<a> Fm() {
        return this.aQh;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aRS;
    }
}
