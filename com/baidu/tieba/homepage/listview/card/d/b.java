package com.baidu.tieba.homepage.listview.card.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.fragment.data.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.HotForum;
import tbclient.HomePage.HotForumItem;
/* loaded from: classes.dex */
public class b implements u, e {
    public static final BdUniqueId bAf = BdUniqueId.gen();
    public long mid = 0;
    public String title = null;
    public String byY = null;
    public String byZ = null;
    public List<a> bAg = null;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bAf;
    }

    public void a(HotForum hotForum) {
        if (hotForum != null) {
            this.mid = hotForum.mid.longValue();
            this.title = hotForum.title;
            this.byY = hotForum.more_text;
            this.byZ = hotForum.more_link;
            if (hotForum.items != null) {
                this.bAg = new ArrayList();
                for (HotForumItem hotForumItem : hotForum.items) {
                    if (hotForumItem != null) {
                        a aVar = new a();
                        aVar.a(hotForumItem);
                        this.bAg.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public long forumId = 0;
        public String forumName = null;
        public String forumAvatar = null;
        public boolean isLiked = false;

        public void a(HotForumItem hotForumItem) {
            if (hotForumItem != null) {
                this.forumId = hotForumItem.forum_id.longValue();
                this.forumName = hotForumItem.forum_name;
                this.forumAvatar = hotForumItem.forum_avatar;
                this.isLiked = hotForumItem.is_liked.intValue() != 0;
            }
        }
    }

    public boolean TN() {
        return y.k(this.bAg) == 0;
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
