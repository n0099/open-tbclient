package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends b {
    public static final BdUniqueId aRS = BdUniqueId.gen();
    private List<com.baidu.adp.widget.ListView.u> aQh = new ArrayList();
    private long aRA;

    public long Kq() {
        return this.aRA;
    }

    public void aq(long j) {
        this.aRA = j;
    }

    public List<com.baidu.adp.widget.ListView.u> Fm() {
        return this.aQh;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aRS;
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.tbadk.core.view.viewpager.a.a {
        public String link;
        public String tag;
        public String title;
        public int type;
        public String url;

        public String getImageUrl() {
            return this.url;
        }
    }
}
