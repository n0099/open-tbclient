package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b {
    public static final BdUniqueId aPP = BdUniqueId.gen();
    private List<u> aOe = new ArrayList();
    private long aPC;

    public long Ix() {
        return this.aPC;
    }

    public void an(long j) {
        this.aPC = j;
    }

    public List<u> DS() {
        return this.aOe;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aPP;
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
