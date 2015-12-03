package com.baidu.tieba.homepage.listview.card.discover;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.Discover;
import tbclient.HomePage.DiscoverItem;
/* loaded from: classes.dex */
public class h implements u, com.baidu.tieba.homepage.fragment.data.e {
    public static final BdUniqueId byX = BdUniqueId.gen();
    public long mid = 0;
    public String title = null;
    public String byY = null;
    public String byZ = null;
    public List<b> bza = null;
    public List<b> bzb = null;
    public List<a> bzc = null;

    /* loaded from: classes.dex */
    public static class a {
        public List<b> awS = new ArrayList();
        public boolean bzd;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return byX;
    }

    public boolean TN() {
        return y.k(this.bzc) == 0;
    }

    public void y(String str, boolean z) {
        if (!StringUtils.isNull(str)) {
            for (b bVar : this.bza) {
                if (bVar != null && str.equals(bVar.statistics)) {
                    bVar.bze = z;
                    return;
                }
            }
        }
    }

    public void a(Discover discover) {
        if (discover != null) {
            this.mid = discover.mid.longValue();
            this.title = discover.title;
            this.byY = discover.more_text;
            this.byZ = discover.more_link;
            if (discover.items != null) {
                this.bza = new ArrayList();
                for (DiscoverItem discoverItem : discover.items) {
                    if (discoverItem != null) {
                        b bVar = new b();
                        bVar.a(discoverItem);
                        this.bza.add(bVar);
                    }
                }
            }
            cY(true);
        }
    }

    public void cY(boolean z) {
        l.IG();
        if (this.bza != null && this.bzb != null) {
            this.bza.addAll(this.bzb);
        }
        l.a(this.bza, this.bzb, z);
        this.bzc = Uc();
    }

    private List<a> Uc() {
        int k = y.k(this.bza);
        if (k <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = ((k % 4 > 0 ? 1 : 0) + (k / 4)) * 4;
        int i2 = 0;
        while (i2 < i) {
            a aVar = new a();
            for (int i3 = 0; i3 < 4; i3++) {
                b bVar = (b) y.b(this.bza, i2 + i3);
                if (bVar != null) {
                    aVar.awS.add(bVar);
                }
            }
            arrayList.add(aVar);
            int i4 = i2 + 4;
            if (i4 >= i) {
                int size = aVar.awS.size();
                for (int i5 = 4 - size > 0 ? 4 - size : 0; i5 > 0; i5--) {
                    aVar.awS.add(null);
                }
                aVar.bzd = true;
            }
            i2 = i4;
        }
        return arrayList;
    }

    /* loaded from: classes.dex */
    public static class b {
        public String iconUrl = null;
        public String title = null;
        public String linkUrl = null;
        public boolean auC = false;
        public boolean bze = false;
        public String bzf = null;
        public String statistics = null;
        private boolean aOu = false;

        public void a(DiscoverItem discoverItem) {
            if (discoverItem != null) {
                this.iconUrl = discoverItem.icon_url;
                this.title = discoverItem.title;
                this.linkUrl = discoverItem.link_url;
                this.auC = discoverItem.is_new.intValue() != 0;
                this.bze = discoverItem.is_red_point.intValue() != 0;
                this.bzf = discoverItem.describe;
                this.statistics = discoverItem.statistics;
            }
        }

        public void cZ(boolean z) {
            this.aOu = z;
        }
    }

    @Override // com.baidu.tieba.homepage.fragment.data.e
    public long getMid() {
        return this.mid;
    }

    @Override // com.baidu.tieba.homepage.fragment.data.e
    public String getTitle() {
        return this.title;
    }

    @Override // com.baidu.tieba.homepage.fragment.data.e
    public String TR() {
        return this.byY;
    }

    @Override // com.baidu.tieba.homepage.fragment.data.e
    public String TS() {
        return this.byZ;
    }
}
