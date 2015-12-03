package com.baidu.tieba.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.a.a.a {
    public static final BdUniqueId aML = BdUniqueId.gen();
    private List<a> aMt = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int aMV;
        public long id;
        public String link;
        public int position;
        public String title;
        public int type;
        public String url;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aML;
    }

    public List<a> Ed() {
        return this.aMt;
    }
}
