package com.baidu.tieba.homepage.listview.card.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.HotActivity;
import tbclient.PicTextItem;
/* loaded from: classes.dex */
public class d implements u, com.baidu.tieba.homepage.fragment.data.e {
    public static final BdUniqueId bzT = BdUniqueId.gen();
    public long mid = 0;
    public String title = null;
    public String byY = null;
    public String byZ = null;
    public List<h> bzU = null;
    public List<a> bzV = null;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bzT;
    }

    public void a(HotActivity hotActivity) {
        if (hotActivity != null) {
            this.mid = hotActivity.mid.longValue();
            this.title = hotActivity.title;
            this.byY = hotActivity.more_text;
            this.byZ = hotActivity.more_link;
            if (hotActivity.carousel_items != null) {
                this.bzU = new ArrayList();
                for (PicTextItem picTextItem : hotActivity.carousel_items) {
                    if (picTextItem != null) {
                        h hVar = new h();
                        hVar.b(picTextItem);
                        this.bzU.add(hVar);
                    }
                }
            }
            if (hotActivity.items != null) {
                this.bzV = new ArrayList();
                for (PicTextItem picTextItem2 : hotActivity.items) {
                    if (picTextItem2 != null) {
                        a aVar = new a();
                        aVar.b(picTextItem2);
                        this.bzV.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String bzW = null;
        public String byT = null;
        public String bzX = null;

        public void b(PicTextItem picTextItem) {
            if (picTextItem != null) {
                this.bzW = picTextItem.item_text;
                this.byT = picTextItem.item_pic;
                this.bzX = picTextItem.item_url;
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
