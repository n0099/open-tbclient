package com.baidu.tieba.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.a.a.a {
    public static final BdUniqueId aML = BdUniqueId.gen();
    private final List<a> aMt = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public long id;
        public String link;
        public int position;
        public String title;
        public String url;
    }

    public void a(a aVar) {
        this.aMt.add(aVar);
    }

    public List<a> Ed() {
        return this.aMt;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aML;
    }
}
