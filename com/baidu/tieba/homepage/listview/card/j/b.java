package com.baidu.tieba.homepage.listview.card.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.homepage.listview.card.c.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.VipCenter;
import tbclient.PicTextItem;
/* loaded from: classes.dex */
public class b implements u, com.baidu.tieba.homepage.fragment.data.e {
    public static final BdUniqueId bBX = BdUniqueId.gen();
    public long mid = 0;
    public String title = null;
    public String byY = null;
    public String byZ = null;
    public String bAU = null;
    public String bBY = null;
    public List<d.a> bBZ = null;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bBX;
    }

    public void a(VipCenter vipCenter) {
        if (vipCenter != null) {
            this.mid = vipCenter.mid.longValue();
            this.title = vipCenter.title;
            this.byY = vipCenter.more_text;
            this.byZ = vipCenter.more_link;
            this.bAU = vipCenter.banner_item_pic;
            this.bBY = vipCenter.banner_item_url;
            if (vipCenter.items != null) {
                this.bBZ = new ArrayList();
                for (PicTextItem picTextItem : vipCenter.items) {
                    if (picTextItem != null) {
                        d.a aVar = new d.a();
                        aVar.b(picTextItem);
                        this.bBZ.add(aVar);
                    }
                }
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
