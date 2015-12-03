package com.baidu.tieba.homepage.listview.card.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.Banner;
import tbclient.PicTextItem;
/* loaded from: classes.dex */
public class a {
    private List<b> byS = null;
    public long mid;

    public List<b> TZ() {
        return this.byS;
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.mid = banner.mid.longValue();
            if (banner.items != null) {
                this.byS = new ArrayList();
                for (PicTextItem picTextItem : banner.items) {
                    if (picTextItem != null) {
                        b bVar = new b();
                        bVar.a(picTextItem);
                        this.byS.add(bVar);
                    }
                }
            }
        }
    }
}
