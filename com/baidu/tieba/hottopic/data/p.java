package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes8.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kvx = BdUniqueId.gen();
    public String hde;
    public String koH;
    public String kvy;
    public String shareTitle;
    public String shareUrl;
    public String tabName;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kvx;
    }

    public void a(TabList tabList) {
        if (tabList != null) {
            this.tabName = tabList.tab_name;
            this.hde = tabList.tab_type;
            this.koH = tabList.share_pic;
            this.shareTitle = tabList.share_title;
            this.kvy = tabList.share_desc;
            this.shareUrl = tabList.share_url;
        }
    }
}
