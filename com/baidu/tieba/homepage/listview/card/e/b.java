package com.baidu.tieba.homepage.listview.card.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.fragment.data.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.GodInfoItem;
import tbclient.HomePage.HotGod;
/* loaded from: classes.dex */
public class b implements u, e {
    public static final BdUniqueId bAm = BdUniqueId.gen();
    public long mid = 0;
    public String title = null;
    public String byY = null;
    public String byZ = null;
    public List<a> bAn = null;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bAm;
    }

    public void a(HotGod hotGod) {
        if (hotGod != null) {
            this.mid = hotGod.mid.longValue();
            this.title = hotGod.title;
            this.byY = hotGod.more_text;
            this.byZ = hotGod.more_link;
            if (hotGod.items != null) {
                this.bAn = new ArrayList();
                for (GodInfoItem godInfoItem : hotGod.items) {
                    if (godInfoItem != null) {
                        a aVar = new a();
                        aVar.a(godInfoItem);
                        this.bAn.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public long uid = 0;
        public String avatar = null;
        public String userName = null;
        public String bAo = null;
        public String bAp = null;
        public long bAq = 0;

        public void a(GodInfoItem godInfoItem) {
            if (godInfoItem != null) {
                this.uid = godInfoItem.uid.longValue();
                this.avatar = godInfoItem.avatar;
                this.userName = godInfoItem.user_name;
                this.bAo = godInfoItem.user_intro;
                this.bAp = godInfoItem.god_intro;
            }
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

    public boolean TN() {
        return y.k(this.bAn) == 0;
    }
}
