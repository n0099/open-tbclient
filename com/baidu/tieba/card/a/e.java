package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends b {
    public static final BdUniqueId TC = BdUniqueId.gen();
    private List<com.baidu.adp.widget.ListView.u> aTc = new ArrayList();
    private long aVi;

    public long LK() {
        return this.aVi;
    }

    public void au(long j) {
        this.aVi = j;
    }

    public List<com.baidu.adp.widget.ListView.u> FZ() {
        return this.aTc;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return TC;
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
        public Object xX() {
            return this.link;
        }
    }
}
