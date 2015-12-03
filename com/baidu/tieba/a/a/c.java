package com.baidu.tieba.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends b {
    public static final BdUniqueId aML = BdUniqueId.gen();
    private long aMD;
    private List<u> aMt = new ArrayList();

    public long Iu() {
        return this.aMD;
    }

    public void am(long j) {
        this.aMD = j;
    }

    public List<u> Ed() {
        return this.aMt;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aML;
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.tbadk.core.view.viewpager.a.a {
        public String link;
        public String tag;
        public String title;
        public int type;
        public String url;

        @Override // com.baidu.tbadk.core.view.viewpager.a.a
        public String getImageUrl() {
            return this.url;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.a.a
        public Object wy() {
            return this.link;
        }
    }
}
