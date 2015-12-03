package com.baidu.tieba.homepage.listview.card.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.HotTopic;
import tbclient.HomePage.HotTopicItem;
/* loaded from: classes.dex */
public class b implements u, com.baidu.tieba.homepage.fragment.data.e {
    public static final BdUniqueId bAT = BdUniqueId.gen();
    public long mid = 0;
    public String title = null;
    public String byY = null;
    public String byZ = null;
    public String bAU = null;
    public long bAV = 0;
    public String bAW = null;
    public long bAX = 0;
    public List<a> bAY = null;
    public List<C0064b> bAZ = null;

    /* renamed from: com.baidu.tieba.homepage.listview.card.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0064b {
        public a bBd = null;
        public a bBe = null;
        public boolean bzd = true;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bAT;
    }

    public boolean TN() {
        return StringUtils.isNull(this.bAU);
    }

    public void a(HotTopic hotTopic) {
        if (hotTopic != null) {
            this.mid = hotTopic.mid.longValue();
            this.title = hotTopic.title;
            this.byY = hotTopic.more_text;
            this.byZ = hotTopic.more_link;
            this.bAU = hotTopic.banner_topic_pic;
            this.bAV = hotTopic.banner_topic_id.longValue();
            this.bAW = hotTopic.banner_topic_name;
            this.bAX = hotTopic.banner_topic_discuss_num.longValue();
            if (hotTopic.items != null) {
                this.bAY = new ArrayList();
                for (HotTopicItem hotTopicItem : hotTopic.items) {
                    if (hotTopicItem != null && !StringUtils.isNull(hotTopicItem.topic_name)) {
                        a aVar = new a();
                        aVar.a(hotTopicItem);
                        this.bAY.add(aVar);
                    }
                }
            }
            this.bAZ = Ue();
        }
    }

    private List<C0064b> Ue() {
        int k = y.k(this.bAY);
        if (k <= 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = (k / 2) * 2;
        if (i > 4) {
            i = 4;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            C0064b c0064b = new C0064b();
            c0064b.bBd = this.bAY.get(i2);
            c0064b.bBe = this.bAY.get(i2 + 1);
            arrayList.add(c0064b);
            int i3 = i2 + 2;
            if (i3 >= i) {
                c0064b.bzd = false;
                break;
            }
            i2 = i3;
        }
        return arrayList;
    }

    /* loaded from: classes.dex */
    public static class a {
        public long bBa = 0;
        public String bBb = null;
        public long bBc = 0;

        public void a(HotTopicItem hotTopicItem) {
            if (hotTopicItem != null) {
                this.bBa = hotTopicItem.topic_id.longValue();
                this.bBb = hotTopicItem.topic_name;
                this.bBc = hotTopicItem.topic_discuss_num.longValue();
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
