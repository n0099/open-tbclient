package com.baidu.tieba.homepage.listview.card.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.homepage.fragment.data.e;
import com.baidu.tieba.homepage.listview.card.c.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.AppItem;
import tbclient.HomePage.FunCenter;
import tbclient.PicTextItem;
/* loaded from: classes.dex */
public class b implements u, e {
    public static final BdUniqueId bzu = BdUniqueId.gen();
    public long mid = 0;
    public String title = null;
    public String byY = null;
    public String byZ = null;
    public List<d.a> bzv = null;
    public List<a> bzw = null;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bzu;
    }

    public void a(FunCenter funCenter) {
        if (funCenter != null) {
            this.mid = funCenter.mid.longValue();
            this.title = funCenter.title;
            this.byY = funCenter.more_text;
            this.byZ = funCenter.more_link;
            if (funCenter.carousel_items != null) {
                this.bzv = new ArrayList();
                for (PicTextItem picTextItem : funCenter.carousel_items) {
                    if (picTextItem != null) {
                        d.a aVar = new d.a();
                        aVar.b(picTextItem);
                        this.bzv.add(aVar);
                    }
                }
            }
            if (funCenter.app_items != null) {
                this.bzw = new ArrayList();
                for (AppItem appItem : funCenter.app_items) {
                    if (appItem != null) {
                        a aVar2 = new a();
                        aVar2.a(appItem);
                        this.bzw.add(aVar2);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String appName = null;
        public String bzx = null;
        public String bzy = null;
        public int bzz = 0;

        public void a(AppItem appItem) {
            if (appItem != null) {
                this.appName = appItem.app_name;
                this.bzx = appItem.app_icon;
                this.bzy = appItem.app_link;
                this.bzz = appItem.icon_type.intValue();
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
}
