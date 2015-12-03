package com.baidu.tieba.homepage.listview.card.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.HotThread;
import tbclient.HomePage.HotThreadItem;
/* loaded from: classes.dex */
public class b implements u, com.baidu.tieba.homepage.fragment.data.e {
    public static final BdUniqueId bAC = BdUniqueId.gen();
    public long mid = 0;
    public String title = null;
    public String byY = null;
    public String byZ = null;
    public List<a> bAD = null;

    public boolean TN() {
        return y.k(this.bAD) == 0;
    }

    public void a(HotThread hotThread) {
        int i;
        int i2 = 0;
        if (hotThread != null) {
            this.mid = hotThread.mid.longValue();
            this.title = hotThread.title;
            this.byY = hotThread.more_text;
            this.byZ = hotThread.more_link;
            if (hotThread.items != null) {
                this.bAD = new ArrayList();
                int size = hotThread.items.size();
                int i3 = size > 3 ? 3 : size;
                int i4 = 0;
                while (i4 < size) {
                    HotThreadItem hotThreadItem = hotThread.items.get(i4);
                    if (hotThreadItem == null || StringUtils.isNull(hotThreadItem.title) || StringUtils.isNull(hotThreadItem.pic_url) || StringUtils.isNull(hotThreadItem.forum_name)) {
                        i = i2;
                    } else {
                        a aVar = new a();
                        aVar.a(hotThreadItem);
                        this.bAD.add(aVar);
                        i = i2 + 1;
                    }
                    if (i != i3) {
                        i4++;
                        i2 = i;
                    } else {
                        return;
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

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bAC;
    }

    /* loaded from: classes.dex */
    public static class a {
        public long bAE = 0;
        public long excId = 0;
        public long tagCode = 0;
        public int bAF = 0;
        public String title = null;
        public String bAG = null;
        public String forumName = null;
        public String picUrl = null;
        public long bAH = 0;
        public long bAI = 0;

        public void a(HotThreadItem hotThreadItem) {
            if (hotThreadItem != null) {
                this.bAE = hotThreadItem.tid.longValue();
                this.excId = hotThreadItem.excid.longValue();
                this.tagCode = hotThreadItem.tag_code.longValue();
                this.bAF = hotThreadItem.pb_type.intValue();
                this.title = hotThreadItem.title;
                this.bAG = hotThreadItem._abstract;
                this.forumName = hotThreadItem.forum_name;
                this.picUrl = hotThreadItem.pic_url;
                this.bAH = hotThreadItem.zan_num.longValue();
                this.bAI = hotThreadItem.comment_num.longValue();
            }
        }
    }
}
